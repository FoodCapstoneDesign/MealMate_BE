package io.junseok.domain.memberwish

import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.domain.memberwish.serviceimpl.MemberWishCreator
import io.junseok.domain.memberwish.serviceimpl.MemberWishDeleter
import io.junseok.domain.memberwish.serviceimpl.MemberWishReader
import io.junseok.domain.memberwish.serviceimpl.MemberWishValidator
import io.junseok.domain.restaurant.Restaurant
import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import io.junseok.domain.restaurant.serviceimpl.RestaurantUpdater
import org.springframework.stereotype.Service

@Service
class MemberWishService(
    private val memberReader: MemberReader,
    private val restaurantReader: RestaurantReader,
    private val memberWishValidator: MemberWishValidator,
    private val memberWishCreator: MemberWishCreator,
    private val memberWishReader: MemberWishReader,
    private val memberWishDeleter: MemberWishDeleter,
    private val restaurantUpdater: RestaurantUpdater
) {
    fun createWishList(restaurantId: Long, email: String): Long {
        val member = memberReader.findMember(email)
        val restaurant = restaurantReader.findById(restaurantId)
        memberWishValidator.validWishList(member, restaurant)
        restaurantUpdater.increaseLikeCount(restaurant)
        return memberWishCreator.create(
            MemberWish(
                member = member,
                restaurant = restaurant
            )
        )
    }

    fun getWishList(email: String):List<MemberWish>{
        val member = memberReader.findMember(email)
        return memberWishReader.findWishList(member)
    }

    fun findWishList(email: String,restaurantId: Long):Boolean{
        val member = memberReader.findMember(email)
        val restaurant = restaurantReader.findById(restaurantId)
        return memberWishValidator.isExistWishList(member, restaurant)
    }

    fun removeWishList(wishlistId: Long){
        memberWishDeleter.delete(wishlistId)
    }
    fun showWishListCount(email: String) = memberWishReader.getWishListCount(email)
}