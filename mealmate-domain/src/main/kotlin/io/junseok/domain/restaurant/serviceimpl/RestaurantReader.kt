package io.junseok.domain.restaurant.serviceimpl

import io.junseok.domain.restaurant.RestaurantRepository
import org.springframework.stereotype.Component

@Component
class RestaurantReader(private val restaurantRepository: RestaurantRepository) {
    fun findAllRestaurant() = restaurantRepository.findAll()

    fun findAllByRestaurantType(restaurantType: String) =
        restaurantRepository.findAllRestaurantType(restaurantType)

    fun findBestRestaurant() = restaurantRepository.findTop3ByOrderByLikeCountDesc()

    fun findById(restaurantId: Long) = restaurantRepository.findById(restaurantId)

    fun findByRestaurantName(restaurantName: String) =
        restaurantRepository.findByRestaurantName(restaurantName)
}