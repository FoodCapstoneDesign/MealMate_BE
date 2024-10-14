package io.junseok.domain.restaurant

import io.junseok.domain.restaurantmenu.RestaurantMenu

data class RestaurantDetail(
    val restaurant: Restaurant,
    val restaurantMenu: List<RestaurantMenu>
)
