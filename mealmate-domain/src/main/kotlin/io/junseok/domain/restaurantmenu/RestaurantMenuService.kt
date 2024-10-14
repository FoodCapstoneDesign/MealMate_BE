package io.junseok.domain.restaurantmenu

import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import io.junseok.domain.restaurantmenu.serviceimpl.RestaurantMenuCreator
import io.junseok.domain.restaurantmenu.serviceimpl.RestaurantMenuDeleter
import org.springframework.stereotype.Service

@Service
class RestaurantMenuService(
    private val restaurantReader: RestaurantReader,
    private val restaurantMenuCreator: RestaurantMenuCreator,
    private val restaurantMenuDeleter: RestaurantMenuDeleter
    ) {
    fun registerMenu(restaurantId: Long, restaurantMenu: List<RestaurantMenu>) {
        val restaurant = restaurantReader.findById(restaurantId)
        restaurantMenuCreator.save(
            RestaurantMenuRegister(
                restaurantMenu = restaurantMenu,
                restaurant = restaurant
            )
        )
    }

    fun deleteMenu(restaurantId: Long) = restaurantMenuDeleter.deleteById(restaurantId)
}