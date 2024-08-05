package com.artist.server.kstarter.web.rest

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.test.context.support.WithSecurityContext
import org.springframework.security.test.context.support.WithSecurityContextFactory
import java.util.*

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@WithSecurityContext(factory = WithAuthenticatedMockUser.Factory::class)
annotation class WithAuthenticatedMockUser(
    val username: String = "admin",
    val password: String = "admin",
    val role: String = "ROLE_ADMIN"
) {

    class Factory : WithSecurityContextFactory<WithAuthenticatedMockUser?> {
        override fun createSecurityContext(annotation: WithAuthenticatedMockUser?): SecurityContext {
            return SecurityContextHolder.createEmptyContext().apply {
                val authenticationToken = UsernamePasswordAuthenticationToken(
                    annotation?.username,
                    annotation?.password,
                    mutableListOf(
                        SimpleGrantedAuthority(annotation?.role)
                    )
                )

                authentication = authenticationToken
            }
        }
    }
}
