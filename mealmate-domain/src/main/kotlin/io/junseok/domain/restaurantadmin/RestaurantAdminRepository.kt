package io.junseok.domain.restaurantadmin

interface RestaurantAdminRepository {
    fun findByEmail(email: String): Admin
    fun save(admin: Admin): Long
    fun deleteAdmin(email: String)
}