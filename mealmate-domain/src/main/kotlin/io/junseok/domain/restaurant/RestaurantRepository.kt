package io.junseok.domain.restaurant

interface RestaurantRepository {
    fun existsByRestaurantName(restaurantName: String): Boolean
    fun existsByRestaurantId(restaurantId: Long): Boolean
    fun save(restaurant: Restaurant): Long?
    fun deleteById(restaurantId: Long)
    fun findAll(): List<Restaurant>
    fun findAllRestaurantType(restaurantType: String): List<Restaurant>
    fun findTop3ByOrderByLikeCountDesc(): List<Restaurant>
    fun findById(restaurantId: Long): Restaurant
    fun findByRestaurantName(restaurantName: String): List<Restaurant>
}