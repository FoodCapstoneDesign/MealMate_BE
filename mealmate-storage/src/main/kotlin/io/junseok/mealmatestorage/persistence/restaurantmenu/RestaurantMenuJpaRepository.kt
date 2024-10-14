package io.junseok.mealmatestorage.persistence.restaurantmenu

import io.junseok.mealmatestorage.persistence.restaurant.RestaurantEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantMenuJpaRepository : JpaRepository<RestaurantMenuEntity,Long> {
    fun findAllByRestaurant(restaurantEntity: RestaurantEntity):List<RestaurantMenuEntity>
}
