package io.junseok.domain.memberwish.serviceimpl

import io.junseok.domain.memberwish.MemberWishRepository
import io.junseok.domain.restaurant.Restaurant
import org.springframework.stereotype.Component

@Component
class MemberWishDeleter(private val memberWishRepository: MemberWishRepository) {
    fun delete(restaurant: Restaurant) = memberWishRepository.deleteByRestaurant(restaurant)
}