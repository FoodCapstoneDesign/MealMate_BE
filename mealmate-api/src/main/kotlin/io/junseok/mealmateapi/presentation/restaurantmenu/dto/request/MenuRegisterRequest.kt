package io.junseok.mealmateapi.presentation.restaurantmenu.dto.request;

import io.junseok.domain.restaurantmenu.RestaurantMenu

data class MenuRegisterRequest(
    val menu: String, val price: String
){
    companion object{
        fun MenuRegisterRequest.toDomain()=RestaurantMenu(
            menu = menu,
            price = price
        )
    }
}
