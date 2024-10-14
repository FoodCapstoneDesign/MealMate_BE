package io.junseok.domain.restaurantmenu.serviceimpl

import io.junseok.domain.restaurantmenu.RestaurantMenuRegister
import io.junseok.domain.restaurantmenu.RestaurantMenuRepository
import org.springframework.stereotype.Component

@Component
class RestaurantMenuCreator(private val restaurantMenuRepository: RestaurantMenuRepository) {
    fun save(restaurantMenuRegister: RestaurantMenuRegister) =
        restaurantMenuRepository.saveAll(restaurantMenuRegister)

}