package io.junseok.mealmateapi.presentation.restaurant.dto.request

import io.junseok.domain.restaurant.RestaurantRegister

data class RestaurantRegisterRequest(
    val restaurantName: String,
    val restaurantType: String,
    val restaurantNotice: String,
    val location: String,
    val telNum: String,
    val openAt: String,
    val closeAt: String
){
    companion object{
        fun RestaurantRegisterRequest.toDomain()=RestaurantRegister(
            restaurantName = this.restaurantName,
            restaurantType = this.restaurantType,
            restaurantNotice = this.restaurantNotice,
            location = this.location,
            telNum = this.telNum,
            openAt = this.openAt,
            closeAt = this.closeAt
        )
    }
}
