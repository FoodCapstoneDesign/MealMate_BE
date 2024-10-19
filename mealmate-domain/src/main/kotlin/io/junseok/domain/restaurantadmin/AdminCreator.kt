package io.junseok.domain.restaurantadmin

import org.springframework.stereotype.Component

@Component
class AdminCreator(private val restaurantAdminRepository: RestaurantAdminRepository) {
    fun save(admin: Admin) = restaurantAdminRepository.save(admin)
}