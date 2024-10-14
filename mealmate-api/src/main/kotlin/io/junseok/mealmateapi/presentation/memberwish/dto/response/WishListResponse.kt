package io.junseok.mealmateapi.presentation.memberwish.dto.response

import io.junseok.domain.memberwish.MemberWish

data class WishListResponse(
    val restaurantName: String,
    val restaurantImageUrl: String,
    val restaurantType: String,
    val likeCount: Int,
    val restaurantId: Long,
    val openAt: String,
    val closeAt: String,
    val wishListId: Long
){
    companion object{
        fun MemberWish.fromWistList()=WishListResponse(
            restaurantName = this.restaurant.restaurantName,
            restaurantImageUrl = this.restaurant.restaurantImageUrl,
            restaurantType = this.restaurant.restaurantType,
            likeCount = this.restaurant.likeCount,
            restaurantId = this.restaurant.restaurantId!!,
            openAt = this.restaurant.openAt,
            closeAt = this.restaurant.closeAt,
            wishListId = this.wishListId!!
        )
    }
}
