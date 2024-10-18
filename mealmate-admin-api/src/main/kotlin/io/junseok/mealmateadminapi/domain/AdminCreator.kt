package io.junseok.mealmateadminapi.domain

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AdminCreator(private val adminJpaRepository: AdminJpaRepository) {
    @Transactional
    fun save(admin: Admin) = adminJpaRepository.save(admin.toEntity()).adminId!!
}