package io.junseok.mealmatestorage.persistence.memberwish

import io.junseok.domain.memberwish.MemberWish
import io.junseok.mealmatestorage.persistence.member.toDomain
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.restaurant.toDomain
import io.junseok.mealmatestorage.persistence.restaurant.toEntity

fun MemberWish.toEntity() = MemberWishEntity(
    member = this.member.toEntity(),
    restaurant = this.restaurant.toEntity()
)

fun MemberWishEntity.toDomain() = MemberWish(
    restaurant = this.restaurant.toDomain(),
    member = this.member.toDomain(),
    wishListId = this.memberWishId
)