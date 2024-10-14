package io.junseok.mealmateapi.auth.config

import io.junseok.mealmateapi.auth.jwt.JwtAccessDeniedHandler
import io.junseok.mealmateapi.auth.jwt.JwtAuthenticationEntryPoint
import io.junseok.mealmateapi.auth.jwt.TokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.filter.CorsFilter

@Configuration
@EnableWebSecurity //기본적인 웹 보안 활성화
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class SecurityConfig(
    private val corsFilter: CorsFilter,
    private val tokenProvider: TokenProvider,
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val jwtAccessDeniedHandler: JwtAccessDeniedHandler
    ) {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    @Throws(Exception::class)
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity
            .csrf().disable()

            .exceptionHandling()
            .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .accessDeniedHandler(jwtAccessDeniedHandler) // enable h2-console

            .and()
            .headers()
            .frameOptions()
            .sameOrigin()

            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .addFilter(corsFilter)
            .formLogin().disable()
            .httpBasic().disable()
            .authorizeHttpRequests()
            .antMatchers("/h2-console/**").permitAll()
            .antMatchers("/favicon.ico").permitAll()
            .anyRequest().permitAll()

            .and()
            .apply(JwtSecurityConfig(tokenProvider))

        return httpSecurity.build()
    }
}