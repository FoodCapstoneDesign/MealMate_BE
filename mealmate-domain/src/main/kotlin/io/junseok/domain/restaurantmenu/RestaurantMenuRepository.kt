package io.junseok.domain.restaurantmenu

import io.junseok.domain.restaurant.Restaurant

interface RestaurantMenuRepository {
    fun findById(restaurantMenuId: Long): RestaurantMenu
    fun saveAll(register: RestaurantMenuRegister)
    fun deleteById(restaurantMenuId: Long)
    fun findAllByRestaurant(restaurant: Restaurant): List<RestaurantMenu>
    fun update(restaurantMenuId: Long, restaurantMenu: RestaurantMenu)
}