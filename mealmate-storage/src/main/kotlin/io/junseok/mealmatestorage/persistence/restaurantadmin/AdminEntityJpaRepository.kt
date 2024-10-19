package io.junseok.mealmatestorage.persistence.restaurantadmin

import org.springframework.data.jpa.repository.JpaRepository

interface AdminEntityJpaRepository : JpaRepository<AdminEntity, Long> {
    fun findByEmail(email: String): AdminEntity?
    fun existsByEmail(email: String): Boolean
    fun findOneWithAuthoritiesByEmail(email: String): AdminEntity?
    fun deleteByEmail(email: String)
}