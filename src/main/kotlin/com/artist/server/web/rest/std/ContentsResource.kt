package com.artist.server.web.rest.std

import com.artist.server.service.std.ContentsService
import com.artist.server.service.std.dto.ContentsResDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

/**
 * REST controller for managing [com.artist.server.domain.core.StdContents].
 */
@RestController
@RequestMapping("/api/v1")
class ContentsResource(
    private val contentsService: ContentsService,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @Value("\${spring.servlet.multipart.location}")
    private var baseFilePath: String? = null

    @PostMapping("/std-contents")
    fun uploadContents(
        @RequestPart(name = "file")
        file: MultipartFile
    ): ResponseEntity<ContentsResDTO> {
        log.debug("REST request to save StdContents : $file")

        val result = contentsService.saveContents(file, baseFilePath, "FOLDER_NAME")
        return ResponseEntity.ok(result)
    }

    @GetMapping("/std-contents/{contentsType}/{date}/{fileName}", produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getContentsImage(
        @PathVariable
        contentsType: String,
        @PathVariable
        date: String,
        @PathVariable
        fileName: String,
    ): ByteArray {
        log.debug("REST request to get Image by path: $contentsType date: $date fileName: $fileName")
        return contentsService.getImage(baseFilePath, contentsType, date, fileName)
    }

    @GetMapping("/std-contents/{contentsType}/{date}/{fileName}/{scale}", produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getContentsImageScale(
        @PathVariable
        contentsType: String,
        @PathVariable
        date: String,
        @PathVariable
        fileName: String,
        @PathVariable
        scale: String,
    ): ByteArray {
        log.debug("REST request to get Image by path: $contentsType date: $date fileName: $fileName scale: $scale")
        return contentsService.getImage(baseFilePath, contentsType, date, fileName, "_${scale.lowercase()}")
    }
}
