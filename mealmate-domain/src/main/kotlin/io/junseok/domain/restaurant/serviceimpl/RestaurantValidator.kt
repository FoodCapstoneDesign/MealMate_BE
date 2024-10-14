package io.junseok.domain.restaurant.serviceimpl

import io.junseok.domain.restaurant.RestaurantRepository
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Component

@Component
class RestaurantValidator(
    private val restaurantRepository: RestaurantRepository
) {
    fun isExist(restaurantName: String){
        if (restaurantRepository.existsByRestaurantName(restaurantName)){
            throw MealMateException(ErrorCode.EXIST_RESTAURANT)
        }
    }

    fun isExistRestaurantById(restaurantId: Long){
        if (!restaurantRepository.existsByRestaurantId(restaurantId)){
            throw MealMateException(ErrorCode.NOT_EXIST_RESTAURANT)
        }
    }
}