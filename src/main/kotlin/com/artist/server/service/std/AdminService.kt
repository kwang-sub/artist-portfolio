package com.artist.server.service.std

import com.artist.server.domain.core.StdAdmin_
import com.artist.server.domain.core.StdAuthority
import com.artist.server.factory.ApiExceptionFactory
import com.artist.server.factory.ErrorCode
import com.artist.server.repository.core.StdAdminRepository
import com.artist.server.repository.std.AdminAuthorityRepository
import com.artist.server.repository.std.AuthorityRepository
import com.artist.server.security.getCurrentUserLogin
import com.artist.server.service.core.mapper.StdAdminMapper
import com.artist.server.service.std.dto.AdminResDTO
import com.artist.server.service.std.dto.AdminSaveReqDTO
import com.artist.server.service.std.exception.RequireFiledException
import com.artist.server.service.std.mapper.AdminReqMapper
import com.artist.server.service.std.mapper.AdminResMapper
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AdminService(
    private val adminAuthorityRepository: AdminAuthorityRepository,
    private val authorityRepository: AuthorityRepository,
    private val stdAdminRepository: StdAdminRepository,
    private val adminReqMapper: AdminReqMapper,
    private val adminResMapper: AdminResMapper,
    private val stdAdminMapper: StdAdminMapper,
    private val passwordEncoder: PasswordEncoder,
    private val apiExceptionFactory: ApiExceptionFactory,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * 어드민 사용자 정보 저장 처리 (insert or update)
     * @param adminSaveReqDTO 어드민 DTO
     * @return 어드민 저장결과
     */
    fun save(
        adminSaveReqDTO: AdminSaveReqDTO,
    ): AdminResDTO {
        log.debug("save admin one : $adminSaveReqDTO")
        return adminSaveReqDTO.id?.let { update(adminSaveReqDTO) } ?: insert(adminSaveReqDTO)
    }

    /**
     * 어드민 정보 레코드 추가 처리
     * @param adminSaveReqDTO 어드민 DTO
     * @return 저장 결과
     */
    fun insert(
        adminSaveReqDTO: AdminSaveReqDTO,
    ): AdminResDTO {
        val adminPassword = adminSaveReqDTO.adminPassword ?: throw RequireFiledException("adminPassword")
        val authorityCode = StdAuthority.CODE_AUTHORITY_ADMIN

        val authority = authorityRepository
            .findByAuthorityCodeAndIsDeletedIsFalse(authorityCode)
            .orElseThrow { apiExceptionFactory.badRequest(ErrorCode.Std.AUTHORITY_NOT_FOUND) }

        if (stdAdminRepository.existsByAdminLoginIdAndIsDeletedFalse(
                adminSaveReqDTO.adminLoginId
            )
        ) throw apiExceptionFactory.badRequest(ErrorCode.Std.ADMIN_ID_IS_DUPLICATED)

        return adminReqMapper
            .toEntity(adminSaveReqDTO)
            .apply {
                this.adminPassword = adminPassword.let { passwordEncoder.encode(it) }
                this.stdAuthorities.add(authority)
            }
            .let { stdAdminRepository.save(it) }
            .let { adminResMapper.toDto(it) }
            .also { applicationEventPublisher.publishEvent(it) }
    }

    /**
     * 어드민 정보 레코드 업데이트 처리
     * @param adminSaveReqDTO 어드민 DTO
     * @return 저장 결과
     */
    fun update(
        adminSaveReqDTO: AdminSaveReqDTO,
    ): AdminResDTO {
        val id = adminSaveReqDTO.id ?: throw RequireFiledException(StdAdmin_.ID)
        val admin = stdAdminRepository.findByIdAndIsDeletedFalse(id) ?: throw apiExceptionFactory.badRequest(
            ErrorCode.Std.ADMIN_NOT_FOUND
        )

        val authorityCode = StdAuthority.CODE_AUTHORITY_ADMIN
        val authority = authorityRepository
            .findByAuthorityCodeAndIsDeletedIsFalse(authorityCode)
            .orElseThrow { apiExceptionFactory.badRequest(ErrorCode.Std.AUTHORITY_NOT_FOUND) }

        if (stdAdminRepository.existsByAdminLoginIdAndIdNotAndIsDeletedFalse(
                adminSaveReqDTO.adminLoginId, id
            )
        ) throw apiExceptionFactory.badRequest(ErrorCode.Std.ADMIN_ID_IS_DUPLICATED)

        return admin
            .also {
                it.stdAuthorities = adminAuthorityRepository
                    .findAllByAdminIdAndIsDeletedIsFalse(id)
                    .map { adminAuthority -> adminAuthority.authorityCode(authority) }
                    .let { adminAuthority -> adminAuthorityRepository.saveAll(adminAuthority) }
                    .filter { adminAuthority -> null != adminAuthority.authorityCode }
                    .map { adminAuthority -> adminAuthority.authorityCode!! }
                    .toMutableSet()
            }
            .apply {
                this.adminLoginId = adminSaveReqDTO.adminLoginId
                this.isActivated = adminSaveReqDTO.isActivated
                this.adminUserName = adminSaveReqDTO.adminUserName
                this.adminPhoneNum = adminSaveReqDTO.adminPhoneNum
                this.adminEmail = adminSaveReqDTO.adminEmail
                adminSaveReqDTO.adminPassword?.let {
                    this.adminPassword = passwordEncoder.encode(it)
                }
            }
            .let { stdAdminRepository.save(it) }
            .let { adminResMapper.toDto(it) }
            .also { applicationEventPublisher.publishEvent(it) }
    }

    fun delete(id: Long) {
        val entity = stdAdminRepository.findByIdAndIsDeletedFalse(id) ?: throw apiExceptionFactory.badRequest(
            ErrorCode.Std.ADMIN_NOT_FOUND
        )

        entity
            .apply { isDeleted = true }
            .also {
                val adminId = it.id ?: return@also
                adminAuthorityRepository
                    .findAllByAdminIdAndIsDeletedIsFalse(adminId)
                    .map { adminAuthority ->
                        adminAuthority.isDeleted = true
                        adminAuthority
                    }
                    .run { adminAuthorityRepository.saveAll(this) }
            }
            .let { stdAdminRepository.save(it) }
    }

    @Transactional(readOnly = true)
    fun findOne(
        id: Long,
    ): AdminResDTO {
        val admin = stdAdminRepository.findByIdAndIsDeletedFalse(id) ?: throw apiExceptionFactory.badRequest(
            ErrorCode.Std.ADMIN_NOT_FOUND
        )
        return adminResMapper.toDto(admin)
    }

    @Transactional(readOnly = true)
    fun getLoginAdminOrNull() = getCurrentUserLogin()
        .orElse(null)
        ?.let { stdAdminRepository.findByAdminLoginIdEqualsAndIsDeletedFalse(it) }
        ?.let { stdAdminMapper.toDto(it) }

    @Transactional(readOnly = true)
    fun getLoginAdminResDTOOrNull() = getCurrentUserLogin()
        .orElse(null)
        ?.let { stdAdminRepository.findByAdminLoginIdEqualsAndIsDeletedFalse(it) }
        ?.let { adminResMapper.toDto(it) }
}
