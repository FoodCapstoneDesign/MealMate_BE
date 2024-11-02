package io.junseok.mealmatestorage.persistence.restaurant

import io.junseok.domain.restaurant.Restaurant
import io.junseok.domain.restaurant.RestaurantRepository
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class RestaurantEntityRepository(
    private val restaurantJpaRepository: RestaurantJpaRepository,
) : RestaurantRepository {
    override fun existsByRestaurantName(restaurantName: String) =
        restaurantJpaRepository.existsByRestaurantName(restaurantName)

    override fun existsByRestaurantId(restaurantId: Long) =
        restaurantJpaRepository.existsByRestaurantId(restaurantId)

    @Transactional
    override fun save(restaurant: Restaurant): Long? =
        restaurantJpaRepository.save(restaurant.toEntity()).restaurantId

    @Transactional
    override fun deleteById(restaurantId: Long) =
        restaurantJpaRepository.deleteByRestaurantId(restaurantId)

    @Transactional(readOnly = true)
    override fun findAll(): List<Restaurant> =
        restaurantJpaRepository.findAll().map { it.toDomain() }

    @Transactional(readOnly = true)
    override fun findAllRestaurantType(restaurantType: String): List<Restaurant> =
        restaurantJpaRepository.findAllByRestaurantType(restaurantType).map { it.toDomain() }

    @Transactional(readOnly = true)
    override fun findTop3ByOrderByLikeCountDesc(): List<Restaurant> =
        restaurantJpaRepository.findTop3ByOrderByLikeCountDesc().map { it.toDomain() }

    @Transactional(readOnly = true)
    override fun findById(restaurantId: Long): Restaurant =
        restaurantJpaRepository.findByIdOrNull(restaurantId)?.toDomain()
            ?: throw MealMateException(ErrorCode.NOT_EXIST_RESTAURANT)

    @Transactional(readOnly = true)
    override fun findByRestaurantName(restaurantName: String): List<Restaurant> =
        restaurantJpaRepository.findByRestaurantNameContains(restaurantName).map {
            it?.toDomain() ?: throw MealMateException(ErrorCode.NOT_EXIST_RESTAURANT)
        }

    @Transactional
    override fun updateLikeCount(restaurant: Restaurant) =
        restaurantJpaRepository.findByIdOrNull(restaurant.restaurantId!!)
            ?.addLikeCount()
            ?: throw MealMateException(ErrorCode.NOT_EXIST_RESTAURANT)
}