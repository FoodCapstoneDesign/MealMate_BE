package io.junseok.mealmatestorage.persistence.restaurantmenu

import io.junseok.domain.restaurantmenu.RestaurantMenu
import io.junseok.domain.restaurantmenu.RestaurantMenuRegister
import io.junseok.mealmatestorage.persistence.restaurant.RestaurantEntity
import io.junseok.mealmatestorage.persistence.restaurant.toDomain

fun RestaurantMenuRegister.toEntity(restaurantEntity: RestaurantEntity): List<RestaurantMenuEntity> {
    return restaurantMenu.map { menu ->
            RestaurantMenuEntity(
                menuName = menu.menu,
                menuPrice = menu.price,
                restaurant = restaurantEntity
            )
        }
}

fun RestaurantMenuEntity.toDomain()=RestaurantMenu(
    menu = this.menuName,
    price = this.menuPrice,
    restaurant = this.restaurant.toDomain()
)