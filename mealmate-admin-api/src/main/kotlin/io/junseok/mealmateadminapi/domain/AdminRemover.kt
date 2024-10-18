package io.junseok.mealmateadminapi.domain

import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AdminRemover(private val adminJpaRepository: AdminJpaRepository) {
    @Transactional
    fun delete(email: String){
        val adminEntity = (adminJpaRepository.findByEmail(email)
            ?: throw MealMateException(ErrorCode.NOT_EXIST_ADMIN))
        adminJpaRepository.delete(adminEntity)
    }
}