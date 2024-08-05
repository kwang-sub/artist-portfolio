package com.artist.server.security

import com.artist.server.domain.core.StdAdmin
import com.artist.server.repository.core.StdAdminRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
class DomainUserDetailsService(private val stdAdminRepository: StdAdminRepository) : UserDetailsService {

    private val log = LoggerFactory.getLogger(javaClass)

    @Transactional(readOnly = true)
    override fun loadUserByUsername(login: String): UserDetails {
        log.debug("Authenticating $login")

        val lowercaseLogin = login.lowercase(Locale.ENGLISH)
        return stdAdminRepository.findByAdminLoginIdEqualsAndIsDeletedFalse(lowercaseLogin)
            ?.let { createSpringSecurityUser(lowercaseLogin, it) }
            ?: throw UsernameNotFoundException("stdAdmin $lowercaseLogin was not found in the database")
    }

    private fun createSpringSecurityUser(
        lowercaseLogin: String,
        admin: StdAdmin
    ): org.springframework.security.core.userdetails.User {
        if (admin.isActivated == null || admin.isActivated == false) {
            throw UserNotActivatedException("stdAdmin $lowercaseLogin was not activated")
        }
        val grantedAuthorities = admin.stdAuthorities.map { SimpleGrantedAuthority(it.authorityCode) }
        return org.springframework.security.core.userdetails.User(
            admin.adminLoginId!!,
            admin.adminPassword!!,
            grantedAuthorities
        )
    }
}
