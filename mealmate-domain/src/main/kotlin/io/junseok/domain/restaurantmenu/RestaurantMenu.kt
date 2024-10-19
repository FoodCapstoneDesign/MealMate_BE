package io.junseok.domain.restaurantmenu

import io.junseok.domain.restaurant.Restaurant

data class RestaurantMenu(
    val menu: String,
    val price: String,
    val restaurant: Restaurant?=null
)
