package io.junseok.mealmateapi.auth

import io.junseok.domain.restaurantadmin.AdminReader
import io.junseok.mealmateapi.auth.dto.LoginDto
import io.junseok.mealmateapi.auth.dto.TokenDto
import io.junseok.mealmateapi.auth.jwt.TokenProvider
import org.springframework.stereotype.Service

@Service
class LoginAdminAuth(
    private val tokenProvider: TokenProvider,
    private val adminReader: AdminReader
) {
    fun login(loginDto: LoginDto): TokenDto{
        val admin = adminReader.findAdmin(loginDto.email)
        val jwt = tokenProvider.createToken(admin.email,admin.authority)
        return TokenDto(jwt,admin.authority)
    }
}