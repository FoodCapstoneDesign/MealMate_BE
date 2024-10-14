package io.junseok.mealmateapi.presentation.restaurant.dto.response

import io.junseok.domain.restaurantmenu.RestaurantMenu
import kotlin.concurrent.thread

data class MenuInfo(
    val menuName: String,
    val menuPrice: String
){
    companion object{
        fun RestaurantMenu.fromMenuInfo()=MenuInfo(
            menuName = this.menu,
            menuPrice = this.price
        )
    }
}