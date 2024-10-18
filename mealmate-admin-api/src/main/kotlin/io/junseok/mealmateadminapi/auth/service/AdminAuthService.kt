package io.junseok.mealmateadminapi.auth.service

import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import io.junseok.mealmateadminapi.auth.jwt.AdminTokenProvider
import io.junseok.mealmateadminapi.auth.dto.LoginDto
import io.junseok.mealmateadminapi.auth.dto.TokenDto
import io.junseok.mealmateadminapi.domain.AdminJpaRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class AdminAuthService(
    private val tokenProvider: AdminTokenProvider,
    private val adminJpaRepository: AdminJpaRepository
) {
    fun login(loginDto: LoginDto): TokenDto {
        val adminEntity = adminJpaRepository.findByEmail(loginDto.email)
            ?: throw MealMateException(ErrorCode.NOT_EXIST_ADMIN)
        val jwt = tokenProvider.createToken(adminEntity.email,adminEntity.authority)
        val authorities = adminEntity.authority
        return TokenDto(
            token = jwt,
            authority =  authorities
        )
    }
}