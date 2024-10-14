package io.junseok.domain.restaurantmenu

import io.junseok.domain.restaurant.Restaurant

data class RestaurantMenuRegister(
    val restaurantMenu: List<RestaurantMenu>,
    val restaurant: Restaurant
)
