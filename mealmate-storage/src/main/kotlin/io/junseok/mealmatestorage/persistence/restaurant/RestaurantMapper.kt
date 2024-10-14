package io.junseok.mealmatestorage.persistence.restaurant

import io.junseok.domain.restaurant.Restaurant

fun Restaurant.toEntity()= RestaurantEntity(
    restaurantId = this.restaurantId,
    restaurantName = this.restaurantName,
    restaurantImageUrl = this.restaurantImageUrl,
    restaurantFileName = this.restaurantFileName,
    restaurantType = this.restaurantType,
    restaurantNotice = this.restaurantNotice,
    location = this.location,
    telNum = this.telNum,
    likeCount = this.likeCount,
    grade = this.grade,
    openAt = this.openAt,
    closeAt = this.closeAt
)

fun RestaurantEntity.toDomain()=Restaurant(
    restaurantId = this.restaurantId!!,
    restaurantName = this.restaurantName,
    restaurantImageUrl = this.restaurantImageUrl,
    restaurantFileName = this.restaurantFileName,
    restaurantType = this.restaurantType,
    restaurantNotice = this.restaurantNotice,
    location = this.location,
    telNum = this.telNum,
    likeCount = this.likeCount,
    grade = this.grade,
    openAt = this.openAt,
    closeAt = this.closeAt
)