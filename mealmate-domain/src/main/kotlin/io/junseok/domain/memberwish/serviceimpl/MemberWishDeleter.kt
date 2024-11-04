package io.junseok.domain.memberwish.serviceimpl

import io.junseok.domain.memberwish.MemberWishRepository
import io.junseok.domain.restaurant.Restaurant
import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import io.junseok.domain.restaurant.serviceimpl.RestaurantUpdater
import org.springframework.stereotype.Component

@Component
class MemberWishDeleter(
    private val memberWishRepository: MemberWishRepository,
    private val restaurantUpdater: RestaurantUpdater
) {
    fun delete(restaurant: Restaurant){
        restaurantUpdater.decreaseLikeCount(restaurant)
        memberWishRepository.deleteByRestaurant(restaurant)
    }
}