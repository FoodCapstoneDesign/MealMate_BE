package io.junseok.domain.memberwish.serviceimpl

import io.junseok.domain.member.Member
import io.junseok.domain.memberwish.MemberWishRepository
import io.junseok.domain.restaurant.Restaurant
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Component

@Component
class MemberWishValidator(private val memberWishRepository: MemberWishRepository) {
    fun validWishList(member: Member, restaurant: Restaurant){
        if(memberWishRepository.existsByRestaurantAndMember(member,restaurant)){
            throw MealMateException(ErrorCode.EXIST_WISHLIST)
        }
    }

    fun isExistWishList(member: Member,restaurant: Restaurant) =
        memberWishRepository.existsByRestaurantAndMember(member, restaurant)
}