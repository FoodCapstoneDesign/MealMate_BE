package io.junseok.domain.restaurant.serviceimpl

import io.junseok.domain.restaurant.RestaurantRepository
import org.springframework.stereotype.Component

@Component
class RestaurantDeleter(
    private val restaurantRepository: RestaurantRepository
) {
    fun delete(restaurantId: Long) = restaurantRepository.deleteById(restaurantId)
}