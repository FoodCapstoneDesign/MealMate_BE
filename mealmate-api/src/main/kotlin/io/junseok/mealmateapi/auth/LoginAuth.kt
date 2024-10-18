package io.junseok.mealmateapi.auth

import io.junseok.domain.auth.LoginAuthService
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import io.junseok.mealmateapi.auth.dto.LoginDto
import io.junseok.mealmateapi.auth.dto.TokenDto
import io.junseok.mealmateapi.auth.jwt.TokenProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class LoginAuth(
    private val tokenProvider: TokenProvider,
    private val loginAuthService: LoginAuthService
) {

    fun login(loginDto: LoginDto): TokenDto {
        val memberEntity = loginAuthService.findMemberByEmail(loginDto.email)
        val jwt = tokenProvider.createToken(
            memberEntity.email,memberEntity.authority
        )
        return TokenDto(jwt,memberEntity.authority)
    }
}
