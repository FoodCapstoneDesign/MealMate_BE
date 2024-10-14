package io.junseok.domain.restaurant.serviceimpl

import io.junseok.domain.restaurant.RestaurantRegister
import io.junseok.domain.restaurant.RestaurantRegister.Companion.toRestaurant
import io.junseok.domain.restaurant.RestaurantRepository
import io.junseok.dto.S3Response
import org.springframework.stereotype.Component

@Component
class RestaurantCreator(
    private val restaurantRepository: RestaurantRepository
) {
    fun create(restaurantRegister: RestaurantRegister, s3Response: S3Response)=
        restaurantRepository.save(restaurantRegister.toRestaurant(s3Response))

}