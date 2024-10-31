package io.junseok.domain.memberwish

import io.junseok.domain.member.Member
import io.junseok.domain.restaurant.Restaurant

interface MemberWishRepository {
    fun existsByRestaurantAndMember(member: Member,restaurant: Restaurant):Boolean
    fun save(memberWish: MemberWish): Long
    fun findAllMember(member: Member): List<MemberWish>
    fun deleteByRestaurant(restaurant: Restaurant)
    fun countByMember(member: Member): Int
}