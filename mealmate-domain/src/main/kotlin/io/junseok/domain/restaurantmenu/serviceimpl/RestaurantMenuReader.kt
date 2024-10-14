package io.junseok.domain.restaurantmenu.serviceimpl

import io.junseok.domain.restaurant.Restaurant
import io.junseok.domain.restaurantmenu.RestaurantMenuRepository
import org.springframework.stereotype.Component

@Component
class RestaurantMenuReader(
    private val restaurantMenuRepository: RestaurantMenuRepository
) {
    fun findAllMenu(restaurant: Restaurant) = restaurantMenuRepository.findAllByRestaurant(restaurant)
}