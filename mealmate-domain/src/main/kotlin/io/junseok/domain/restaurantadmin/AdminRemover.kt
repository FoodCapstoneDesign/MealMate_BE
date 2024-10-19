package io.junseok.domain.restaurantadmin

import org.springframework.stereotype.Component

@Component
class AdminRemover(private val restaurantAdminRepository: RestaurantAdminRepository) {
    fun delete(email: String) = restaurantAdminRepository.deleteAdmin(email)
}