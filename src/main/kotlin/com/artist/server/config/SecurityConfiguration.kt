package com.artist.server.config

import com.artist.server.domain.core.StdAuthority
import com.artist.server.security.jwt.JWTConfigurer
import com.artist.server.security.jwt.TokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.CorsFilter
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport
import tech.jhipster.config.JHipsterProperties

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Import(SecurityProblemSupport::class)
class SecurityConfiguration(
    private val jHipsterProperties: JHipsterProperties,
    private val tokenProvider: TokenProvider,
    private val corsFilter: CorsFilter,
    private val problemSupport: SecurityProblemSupport
) {

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf()
            .disable()
            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter::class.java)
            .exceptionHandling()
            .authenticationEntryPoint(problemSupport)
            .accessDeniedHandler(problemSupport)
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers("/swagger-ui/**").permitAll()
            .antMatchers("/test/**").permitAll()
            .antMatchers("/api/core/authenticate").permitAll()
            .antMatchers("/api/core/register").permitAll()
            .antMatchers("/api/core/activate").permitAll()
            .antMatchers("/api/core/account/reset-password/init").permitAll()
            .antMatchers("/api/core/account/reset-password/finish").permitAll()
            .antMatchers("/api/v1/std-contents/SIGN/**").permitAll()
            .antMatchers("/api/v1/std-contents/SUV_QES/**").permitAll()
            .antMatchers("/api/v1/std-contents/LOGO/**").permitAll()
            .antMatchers("/api/v1/alarm-talks/webhook").permitAll()
            .antMatchers("/api/v1/jwt/survey").permitAll()
            .antMatchers("/api/core/admin/**").hasAuthority(StdAuthority.CODE_AUTHORITY_ADMIN)
            .antMatchers("/api/**").authenticated()
            .antMatchers("/management/health").permitAll()
            .antMatchers("/management/health/**").permitAll()
            .antMatchers("/management/info").permitAll()
            .antMatchers("/management/prometheus").permitAll()
            .antMatchers("/management/**").hasAuthority(StdAuthority.CODE_AUTHORITY_ADMIN)
            .and()
            .httpBasic()
            .and()
            .apply(securityConfigurerAdapter())
        return http.build()
    }

    private fun securityConfigurerAdapter() = JWTConfigurer(tokenProvider)
}
