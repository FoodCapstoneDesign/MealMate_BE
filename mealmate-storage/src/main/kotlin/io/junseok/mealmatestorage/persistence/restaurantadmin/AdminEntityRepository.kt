package io.junseok.mealmatestorage.persistence.restaurantadmin

import io.junseok.domain.restaurantadmin.Admin
import io.junseok.domain.restaurantadmin.RestaurantAdminRepository
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class AdminEntityRepository(
    private val adminEntityJpaRepository: AdminEntityJpaRepository
) : RestaurantAdminRepository {

    @Transactional(readOnly = true)
    override fun findByEmail(email: String): Admin =
        adminEntityJpaRepository.findByEmail(email)?.toAdmin()
            ?: throw MealMateException(ErrorCode.NOT_EXIST_ADMIN)

    @Transactional
    override fun save(admin: Admin): Long =
        adminEntityJpaRepository.save(admin.toEntity()).adminId!!

    @Transactional
    override fun deleteAdmin(email: String) =
        adminEntityJpaRepository.deleteByEmail(email)

}