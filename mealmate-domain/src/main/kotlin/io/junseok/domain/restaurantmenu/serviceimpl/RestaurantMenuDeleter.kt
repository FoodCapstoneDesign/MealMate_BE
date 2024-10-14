package io.junseok.domain.restaurantmenu.serviceimpl

import io.junseok.domain.restaurantmenu.RestaurantMenuRepository
import org.springframework.stereotype.Component

@Component
class RestaurantMenuDeleter(private val restaurantMenuRepository: RestaurantMenuRepository) {
    fun deleteById(restaurantMenuId: Long) =restaurantMenuRepository.deleteById(restaurantMenuId)
}