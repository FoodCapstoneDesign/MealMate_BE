package io.junseok.mealmateapi.auth

import io.junseok.domain.auth.LoginAuthService
import io.junseok.mealmateapi.auth.dto.LoginDto
import io.junseok.mealmateapi.auth.dto.TokenDto
import io.junseok.mealmateapi.auth.jwt.TokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class LoginAuth(
    private val tokenProvider: TokenProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val loginAuthService: LoginAuthService
) {

    fun login(loginDto: LoginDto): TokenDto {
        if(!loginAuthService.isExistEmail(loginDto.email)){
            throw IllegalStateException("존재하지 않는 사용자입니다!")
        }

        val authenticationToken = UsernamePasswordAuthenticationToken(
            loginDto.email,loginDto.password
        )

        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        SecurityContextHolder.getContext().authentication = authentication
        val jwt = tokenProvider.createToken(authentication)
        return TokenDto(jwt)
    }
}
