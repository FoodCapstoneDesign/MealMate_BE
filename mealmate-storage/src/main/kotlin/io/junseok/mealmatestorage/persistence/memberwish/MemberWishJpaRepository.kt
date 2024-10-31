package io.junseok.mealmatestorage.persistence.memberwish

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import io.junseok.mealmatestorage.persistence.restaurant.RestaurantEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberWishJpaRepository : JpaRepository<MemberWishEntity,Long> {
    fun existsByRestaurantAndMember(restaurantEntity: RestaurantEntity,memberEntity: MemberEntity): Boolean
    fun findAllByMember(memberEntity: MemberEntity):List<MemberWishEntity>
    fun countByMember(memberEntity: MemberEntity): Int
    fun deleteByRestaurant(restaurantEntity: RestaurantEntity)
}