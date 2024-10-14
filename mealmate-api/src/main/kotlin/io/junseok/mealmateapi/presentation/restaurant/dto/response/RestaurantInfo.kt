package io.junseok.mealmateapi.presentation.restaurant.dto.response

import io.junseok.domain.restaurant.Restaurant

data class RestaurantInfo(
    val restaurantName: String,
    val restaurantImageUrl: String,
    val restaurantType: String,
    val likeCount: Int,
    val restaurantId: Long,
    val openAt: String,
    val closeAt: String,
){
    companion object{
        fun Restaurant.fromRestaurant()=RestaurantInfo(
            restaurantName = this.restaurantName,
            restaurantImageUrl = this.restaurantImageUrl,
            restaurantType = this.restaurantType,
            likeCount = this.likeCount,
            restaurantId = this.restaurantId!!,
            openAt = this.openAt,
            closeAt = this.closeAt
        )
    }
}