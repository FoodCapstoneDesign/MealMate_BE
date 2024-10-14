package io.junseok.mealmatestorage.persistence.restaurantmenu

import io.junseok.domain.restaurant.Restaurant
import io.junseok.domain.restaurantmenu.RestaurantMenu
import io.junseok.domain.restaurantmenu.RestaurantMenuRegister
import io.junseok.domain.restaurantmenu.RestaurantMenuRepository
import io.junseok.mealmatestorage.persistence.restaurant.toEntity
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class RestaurantMenuEntityRepository(
    private val restaurantMenuJpaRepository: RestaurantMenuJpaRepository
): RestaurantMenuRepository {
    override fun findById(restaurantMenuId: Long): RestaurantMenu {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun saveAll(register: RestaurantMenuRegister) {
        restaurantMenuJpaRepository.saveAll(register.toEntity(register.restaurant.toEntity()))
    }

    @Transactional
    override fun deleteById(restaurantMenuId: Long) {
        restaurantMenuJpaRepository.deleteById(restaurantMenuId)
    }

    @Transactional(readOnly = true)
    override fun findAllByRestaurant(restaurant: Restaurant): List<RestaurantMenu> =
        restaurantMenuJpaRepository.findAllByRestaurant(restaurant.toEntity()).map { it.toDomain() }
}