package com.artist.server.service.std

import com.artist.server.domain.core.StdAdminPassword
import com.artist.server.factory.ApiExceptionFactory
import com.artist.server.factory.ErrorCode
import com.artist.server.repository.core.StdAdminPasswordRepository
import com.artist.server.repository.core.StdAdminRepository
import com.artist.server.service.std.dto.AdminPasswordReqDTO
import com.artist.server.service.std.dto.AdminResDTO
import com.artist.server.service.std.mapper.AdminResMapper
import org.jetbrains.annotations.NotNull
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AdminPasswordService(
    private val stdAdminPasswordRepository: StdAdminPasswordRepository,
    private val stdAdminRepository: StdAdminRepository,
    private val adminResMapper: AdminResMapper,
    private val apiExceptionFactory: ApiExceptionFactory,
    private val passwordEncoder: PasswordEncoder,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * 어드민 사용자 비밀번호 재설정 처리
     * @param adminPasswordReqDTO 어드민 비밀번호 DTO
     * @return 어드민 비밀번호 저장결과
     */
    fun reset(
        @NotNull
        adminPasswordReqDTO: AdminPasswordReqDTO,
    ): AdminResDTO {
        log.debug("reset admin password : $adminPasswordReqDTO")
        val loginUserId = SecurityContextHolder.getContext().authentication.name

        if (adminPasswordReqDTO.afterAdminPassword != adminPasswordReqDTO.afterAdminPasswordCheck) throw apiExceptionFactory.badRequest(
            ErrorCode.Std.ADMIN_PASSWORD_IS_NOT_EQUALS
        )

        val admin = stdAdminRepository
            .findById(adminPasswordReqDTO.adminId)
            .orElseThrow { apiExceptionFactory.badRequest(ErrorCode.Std.ADMIN_NOT_FOUND) }

        if (!passwordEncoder.matches(adminPasswordReqDTO.beforeAdminPassword, admin.adminPassword)) {
            throw apiExceptionFactory.badRequest(ErrorCode.Std.ADMIN_PASSWORD_IS_NOT_EQUALS)
        }

        if (admin.adminLoginId != loginUserId) {
            throw apiExceptionFactory.badRequest(ErrorCode.Std.AUTHORITY_BAD_PERMISSION)
        }

        StdAdminPassword(
            beforePassword = admin.adminPassword,
            afterPassword = passwordEncoder.encode(adminPasswordReqDTO.afterAdminPassword),
        )
            .also { adminPassword -> adminPassword.afterPassword?.let { admin.adminPassword = it } }
            .apply { this.admin = admin }
            .let { stdAdminPasswordRepository.save(it) }

        return adminResMapper.toDto(admin)
    }
}
