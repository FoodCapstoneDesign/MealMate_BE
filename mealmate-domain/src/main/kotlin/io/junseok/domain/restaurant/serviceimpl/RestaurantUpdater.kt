package io.junseok.domain.restaurant.serviceimpl

import io.junseok.domain.restaurant.Restaurant
import io.junseok.domain.restaurant.RestaurantRepository
import org.springframework.stereotype.Component

@Component
class RestaurantUpdater(
    private val restaurantRepository: RestaurantRepository
) {
    fun increaseLikeCount(restaurant: Restaurant)=
        restaurantRepository.updateLikeCount(restaurant)

}