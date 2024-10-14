package io.junseok.mealmatestorage.persistence.board

import io.junseok.mealmatestorage.persistence.restaurant.RestaurantEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BoardEntityJpaRepository : JpaRepository<BoardEntity,Long> {
    fun findAllByOrderByCreateDtDesc(pageable: Pageable): Page<BoardEntity>
    fun findAllByRestaurantOrderByCreateDtDesc(
        pageable: Pageable,
        restaurantEntity: RestaurantEntity
    ):Page<BoardEntity>
}