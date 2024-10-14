package io.junseok.mealmatestorage.persistence.restaurant

import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantJpaRepository : JpaRepository<RestaurantEntity, Long> {
    fun existsByRestaurantName(restaurantName: String): Boolean
    fun existsByRestaurantId(restaurantId: Long): Boolean
    fun deleteByRestaurantId(restaurantId: Long)
    fun findAllByRestaurantType(restaurantType: String): List<RestaurantEntity>
    fun findTop3ByOrderByLikeCountDesc(): List<RestaurantEntity>
    fun findByRestaurantNameContains(restaurantName: String): List<RestaurantEntity?>
}