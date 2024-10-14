package io.junseok.domain.restaurant

import io.junseok.dto.S3Response

data class RestaurantRegister(
    val restaurantName: String,
    val restaurantType: String,
    val restaurantNotice: String,
    val location: String,
    val telNum: String,
    val openAt: String,
    val closeAt: String
){
    companion object{
        fun RestaurantRegister.toRestaurant(s3Response: S3Response)=Restaurant(
            restaurantName = this.restaurantName,
            restaurantType = this.restaurantType,
            restaurantNotice = this.restaurantNotice,
            location = this.location,
            telNum = this.telNum,
            openAt = this.openAt,
            closeAt = this.closeAt,
            restaurantImageUrl = s3Response.imageUrl,
            restaurantFileName = s3Response.fileName,
            grade = 0.0,
            likeCount = 0
        )
    }
}
