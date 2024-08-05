package com.artist.server.service.std

import com.artist.server.domain.core.StdContents
import com.artist.server.factory.ApiExceptionFactory
import com.artist.server.factory.ErrorCode
import com.artist.server.repository.std.ContentsRepository
import com.artist.server.service.std.dto.ContentsResDTO
import com.artist.server.service.std.mapper.ContentsResMapper
import net.coobird.thumbnailator.Thumbnails
import org.apache.commons.compress.utils.FileNameUtils
import org.apache.commons.compress.utils.IOUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import javax.imageio.ImageIO

/**
 * Service Implementation for managing [StdContents].
 */
@Service
@Transactional
class ContentsService(
    private val contentsResMapper: ContentsResMapper,
    private val contentsRepository: ContentsRepository,
    private val apiExceptionFactory: ApiExceptionFactory,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * 이미지를 저장한다
     *
     * @param file                  업로드 된 파일
     * @param baseUploadFilePath    이미지 기본경로
     * @param contentsType          SIGN (서명이미지) / SUV_QES (설문질문문항이미지)
     */
    fun saveContents(
        file: MultipartFile,
        baseUploadFilePath: String?,
        contentsType: String?
    ): ContentsResDTO {
        baseUploadFilePath ?: throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)
        contentsType ?: throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)

        val now = ZonedDateTime.now()

        val originalFileFullName = file.originalFilename
//        val originalName = FileNameUtils.getBaseName(originalFileFullName)
        val originalExt = FileNameUtils.getExtension(originalFileFullName)
        val originFileSize = file.size
        val originContentType = file.contentType
        val yyyyMMdd = SimpleDateFormat("yyyyMMdd").format(Date.from(now.toInstant()))

        val fileName = "${Timestamp.valueOf(now.toLocalDateTime()).time}.$originalExt"
        val savePath = "$contentsType${File.separator}$yyyyMMdd"
        val saveFullPath = "$baseUploadFilePath${File.separator}$savePath"

        val origin = File(saveFullPath, fileName)
        try {
            val makeDirs = origin.mkdirs()
            log.debug("makeDirs $makeDirs")
            if (!makeDirs) throw apiExceptionFactory.badRequest(ErrorCode.Std.CONTENT_UPLOAD_FAILED)

            file.transferTo(origin)
        } catch (e: IOException) {
            throw apiExceptionFactory.badRequest(ErrorCode.Std.CONTENT_UPLOAD_FAILED)
        } catch (e: IllegalStateException) {
            throw apiExceptionFactory.badRequest(ErrorCode.Std.CONTENT_UPLOAD_FAILED)
        }

        val originDTO = ContentsResDTO(
            contentsCreateDate = now,
            contentsName = fileName,
            contentsOgName = originalFileFullName,
            contentsPath = savePath,
            contentsSize = originFileSize.toInt(),
            contentsType = originContentType,
        )

        saveThumbnailImages(origin, originDTO)

        return contentsResMapper
            .toEntity(originDTO)
            .let { contentsRepository.save(it) }
            .let { contentsResMapper.toDto(it) }
    }

    /**
     * 썸네일 이미지를 생성하여 저장한다
     *
     * @param origin        원본 이미지 파일
     * @param originDTO     원본 이미지 파일 정보
     */
    private fun saveThumbnailImages(
        origin: File,
        originDTO: ContentsResDTO
    ) {
        val bufferedImage = ImageIO.read(origin)

        val path = origin.parent
        val name = FileNameUtils.getBaseName(origin.name)
        val ext = FileNameUtils.getExtension(origin.name)

        val width = bufferedImage.width.toFloat()
        val height = bufferedImage.height.toFloat()

        val s = File(path, "${name}_s.$ext")
        val m = File(path, "${name}_m.$ext")
        val l = File(path, "${name}_l.$ext")

        Thumbnails
            .of(bufferedImage)
            .size((width * 0.25f).toInt(), (height * 0.25f).toInt())
            .toFile(s)
        Thumbnails
            .of(bufferedImage)
            .size((width * 0.5f).toInt(), (height * 0.5f).toInt())
            .toFile(m)
        Thumbnails
            .of(bufferedImage)
            .size((width * 0.75f).toInt(), (height * 0.75f).toInt())
            .toFile(l)

        originDTO
            .copy()
            .apply {
                contentsName = "${FileNameUtils.getBaseName(s.name)}.${FileNameUtils.getExtension(s.name)}"
                contentsSize = s
                    .length()
                    .toInt()
            }
            .also {
                contentsResMapper
                    .toEntity(it)
                    .run { contentsRepository.save(this) }
            }
            .apply {
                contentsName = "${FileNameUtils.getBaseName(m.name)}.${FileNameUtils.getExtension(m.name)}"
                contentsSize = m
                    .length()
                    .toInt()
            }
            .also {
                contentsResMapper
                    .toEntity(it)
                    .run { contentsRepository.save(this) }
            }
            .apply {
                contentsName = "${FileNameUtils.getBaseName(l.name)}.${FileNameUtils.getExtension(l.name)}"
                contentsSize = l
                    .length()
                    .toInt()
            }
            .also {
                contentsResMapper
                    .toEntity(it)
                    .run { contentsRepository.save(this) }
            }
    }

    /**
     * tbl_std_contents.id 로 ContentsResDTO 를 반환한다
     *
     * @param id tbl_std_contents.id
     * @return ContentsResDTO
     */
    fun getContentsImageDTO(id: Long): ContentsResDTO {
        val image = contentsRepository
            .findById(id)
            .orElseThrow { apiExceptionFactory.badRequest(ErrorCode.Std.NOT_FOUND_FILE) }

        return contentsResMapper.toDto(image)
    }

    /**
     * ContentResDTO 를 이미지 Byte Array 로 반환한다
     *
     * @param baseUploadFilePath    이미지 기본경로
     * @param dto                   ContentsResDTO
     * @param suffix                null : 원본 / s : 25% / m : 50% / l : 75% 로 스케일 된 이미지
     * @return Image Byte Array
     */
    fun getContentsImageByteArray(
        baseUploadFilePath: String?,
        dto: ContentsResDTO,
        suffix: String?
    ): ByteArray {
        val contentFullPath = dto.contentsPath ?: throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)
        val contentSplit = contentFullPath.split("\\")
        if (contentSplit.size != 2) {
            throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)
        }

        val contentPath = contentFullPath.split("\\")[0]
        val date = contentFullPath.split("\\")[1]
        val fileName = dto.contentsName

        return getImage(baseUploadFilePath, contentPath, date, fileName, suffix)
    }

    /**
     * 이미지 정보를 Image ByteArray 로 반환한다
     *
     * @param baseUploadFilePath    이미지 기본경로
     * @param contentsType          SIGN (서명이미지) / SUV_QES (설문질문문항이미지)
     * @param date                  저장된 날짜
     * @param fileName              파일명 (확장자 포함)
     * @param suffix                null : 원본 / s : 25% / m : 50% / l : 75% 로 스케일 된 이미지
     * @return Image Byte Array
     */
    fun getImage(
        baseUploadFilePath: String?,
        contentsType: String?,
        date: String?,
        fileName: String?,
        suffix: String? = ""
    ): ByteArray {
        baseUploadFilePath ?: throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)
        contentsType ?: throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)
        date ?: throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)
        fileName ?: throw apiExceptionFactory.badRequest(ErrorCode.Std.BAD_CONTENT_PATH)

        val name = FileNameUtils.getBaseName(fileName)
        val ext = FileNameUtils.getExtension(fileName)

        val file =
            File("${baseUploadFilePath}${File.separator}${contentsType}${File.separator}$date", "$name$suffix.$ext")
        if (!file.exists()) throw apiExceptionFactory.badRequest(ErrorCode.Std.NOT_FOUND_FILE)

        var fis: FileInputStream? = null
        try {
            fis = FileInputStream(file)
            return IOUtils.toByteArray(fis)
        } catch (e: Exception) {
            throw apiExceptionFactory.badRequest(ErrorCode.Std.FAILED_TO_FILE_TO_BYTE_ARRAY)
        } finally {
            fis?.close()
        }
    }
}
