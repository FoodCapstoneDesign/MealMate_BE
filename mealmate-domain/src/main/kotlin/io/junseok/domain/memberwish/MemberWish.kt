package io.junseok.domain.memberwish

import io.junseok.domain.member.Member
import io.junseok.domain.restaurant.Restaurant

data class MemberWish(
    val member: Member,
    val restaurant: Restaurant,
    val wishListId: Long? = null
)
