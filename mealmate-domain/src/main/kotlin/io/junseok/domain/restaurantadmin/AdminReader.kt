package io.junseok.domain.restaurantadmin

import org.springframework.stereotype.Component

@Component
class AdminReader(private val restaurantAdminRepository: RestaurantAdminRepository) {
    fun findAdmin(email: String) = restaurantAdminRepository.findByEmail(email)

}