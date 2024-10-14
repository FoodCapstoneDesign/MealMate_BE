package io.junseok.mealmateapi.presentation.restaurant.dto.response

import io.junseok.domain.restaurant.RestaurantDetail
import io.junseok.mealmateapi.presentation.restaurant.dto.response.MenuInfo.Companion.fromMenuInfo

data class RestaurantDetailInfo(
    val restaurantName: String,
    val restaurantImageUrl: String,
    val restaurantType: String,
    val restaurantTelNum: String,
    val location: String,
    val likeCount: Int,
    val grade: Double,
    val openAt: String,
    val closeAt: String,
    val restaurantNotice: String,
    val menuList: List<MenuInfo>
){
    companion object{
        fun RestaurantDetail.fromRestaurantDetailInfo()=RestaurantDetailInfo(
            restaurantName = this.restaurant.restaurantName,
            restaurantImageUrl = this.restaurant.restaurantImageUrl,
            restaurantType = this.restaurant.restaurantType,
            restaurantTelNum = this.restaurant.telNum,
            restaurantNotice = this.restaurant.restaurantNotice,
            location = this.restaurant.location,
            likeCount = this.restaurant.likeCount,
            grade = this.restaurant.grade,
            openAt = this.restaurant.openAt,
            closeAt = this.restaurant.closeAt,
            menuList = this.restaurantMenu.map { it.fromMenuInfo() }
        )
    }
}