package com.artist.server.web.rest.std

import com.artist.server.security.jwt.JWTFilter
import com.artist.server.security.jwt.TokenProvider
import com.artist.server.service.std.AdminService
import com.artist.server.service.std.dto.AdminResDTO
import com.artist.server.service.std.dto.LoginReqDTO
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api/core")
class UserJWTController(
    private val adminService: AdminService,
    private val tokenProvider: TokenProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder
) {

    @PostMapping("/authenticate")
    fun authorize(
        @Valid
        @RequestBody
        loginReqDTO: LoginReqDTO
    ): ResponseEntity<JWTToken> {

        val authenticationToken = UsernamePasswordAuthenticationToken(loginReqDTO.username, loginReqDTO.password)

        val authentication = authenticationManagerBuilder
            .getObject()
            .authenticate(authenticationToken)
        SecurityContextHolder.getContext().authentication = authentication
        val jwt = tokenProvider.createToken(authentication, loginReqDTO.isRememberMe ?: false)
        val httpHeaders = HttpHeaders()
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer $jwt")
        return ResponseEntity(JWTToken(jwt, adminService.getLoginAdminResDTOOrNull()), httpHeaders, HttpStatus.OK)
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    class JWTToken(
        @get:JsonProperty("accessToken")
        var accessToken: String?,
        var admin: AdminResDTO?
    )
}
