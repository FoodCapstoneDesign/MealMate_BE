package io.junseok.domain.restaurantmenu.serviceimpl

import io.junseok.domain.restaurantmenu.RestaurantMenu
import io.junseok.domain.restaurantmenu.RestaurantMenuRepository
import org.springframework.stereotype.Component

@Component
class RestaurantMenuUpdater(private val restaurantMenuRepository: RestaurantMenuRepository) {
    fun modify(restaurantMenuId: Long, restaurantMenu: RestaurantMenu) =
        restaurantMenuRepository.update(restaurantMenuId, restaurantMenu)
}