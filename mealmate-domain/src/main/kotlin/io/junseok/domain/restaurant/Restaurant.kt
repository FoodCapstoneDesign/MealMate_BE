package io.junseok.domain.restaurant

data class Restaurant(
    val restaurantId: Long?= null,
    val restaurantName: String,
    val restaurantImageUrl: String,
    val restaurantFileName: String,
    val restaurantType: String,
    val likeCount: Int,
    val location: String,
    val telNum: String,
    val openAt: String,
    val closeAt: String,
    val restaurantNotice: String,
    val grade: Double,
)
