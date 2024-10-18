package io.junseok.mealmateadminapi.domain

import org.springframework.data.jpa.repository.JpaRepository

interface AdminJpaRepository : JpaRepository<AdminEntity, Long> {
    fun findByEmail(email: String): AdminEntity?
    fun existsByEmail(email: String): Boolean
    fun findOneWithAuthoritiesByEmail(email: String): AdminEntity?
}