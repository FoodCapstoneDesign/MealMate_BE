package io.junseok.domain.restaurantmenu

import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import io.junseok.domain.restaurantadmin.AdminReader
import io.junseok.domain.restaurantmenu.serviceimpl.RestaurantMenuCreator
import io.junseok.domain.restaurantmenu.serviceimpl.RestaurantMenuDeleter
import io.junseok.domain.restaurantmenu.serviceimpl.RestaurantMenuReader
import io.junseok.domain.restaurantmenu.serviceimpl.RestaurantMenuUpdater
import org.springframework.stereotype.Service

@Service
class RestaurantMenuService(
    private val restaurantReader: RestaurantReader,
    private val restaurantMenuCreator: RestaurantMenuCreator,
    private val restaurantMenuDeleter: RestaurantMenuDeleter,
    private val restaurantMenuReader: RestaurantMenuReader,
    private val restaurantMenuUpdater: RestaurantMenuUpdater,
    private val adminReader: AdminReader
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

    fun updateMenu(
        restaurantMenuId: Long,
        restaurantMenu: RestaurantMenu,
        email: String
    ) {
        val admin = adminReader.findAdmin(email)
        val menu = restaurantMenuReader.findMenu(restaurantMenuId)
        if(admin.restaurantName == menu.restaurant!!.restaurantName){
            restaurantMenuUpdater.modify(restaurantMenuId,restaurantMenu)
        }
    }
}