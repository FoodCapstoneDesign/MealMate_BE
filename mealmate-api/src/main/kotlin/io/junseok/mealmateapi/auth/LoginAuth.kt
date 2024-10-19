package io.junseok.mealmateapi.auth

import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.mealmateapi.auth.dto.LoginDto
import io.junseok.mealmateapi.auth.dto.TokenDto
import io.junseok.mealmateapi.auth.jwt.TokenProvider
import org.springframework.stereotype.Service

@Service
class LoginAuth(
    private val tokenProvider: TokenProvider,
    private val memberReader: MemberReader
) {

    fun login(loginDto: LoginDto): TokenDto {
        val memberEntity = memberReader.findMember(loginDto.email)
        val jwt = tokenProvider.createToken(
            memberEntity.email,memberEntity.authority
        )
        return TokenDto(jwt,memberEntity.authority)
    }
}
