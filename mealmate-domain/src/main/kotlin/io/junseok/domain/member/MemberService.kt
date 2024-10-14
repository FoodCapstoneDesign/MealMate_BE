package io.junseok.domain.member

import io.junseok.domain.member.serviceimpl.*
import io.junseok.domain.membercategory.serviceimpl.MemberCategoryCreator
import io.junseok.domain.membercategory.serviceimpl.MemberCategoryReader
import io.junseok.domain.membercategory.serviceimpl.MemberCategoryUpdater
import io.junseok.domain.restaurant.Restaurant
import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import io.junseok.toEncrypt
import org.springframework.stereotype.Component

@Component
class MemberService(
    private val memberCreator: MemberCreator,
    private val memberCategoryCreator: MemberCategoryCreator,
    private val memberReader: MemberReader,
    private val memberDeleter: MemberDeleter,
    private val memberValidator: MemberValidator,
    private val memberUpdater: MemberUpdater,
    private val memberCategoryUpdater: MemberCategoryUpdater,
    private val memberCategoryReader: MemberCategoryReader,
    private val restaurantReader: RestaurantReader
) {
    fun createMember(memberSignUp: MemberSignUp): Long {
        val memberId = memberCreator.generate(memberSignUp)
        memberCategoryCreator.generate(memberSignUp.categoryRegisters,memberId)
        return memberId
    }

    fun showMemberInfo(email: String): MemberWithCategory {
        val member = memberReader.findMember(email)
        val categoryRegisters = memberCategoryReader.findCategoryList(email)
        return MemberWithCategory(
            member = member,
            categoryRegisters = categoryRegisters
        )
    }

    fun resignMember(email: String) = memberDeleter.delete(email)

    fun validEmail(memberEmail: MemberEmail) = memberValidator.validEmail(memberEmail.email)

    fun updateMember(memberModify: MemberModify, email: String){
        val member = memberReader.findMember(email)
        memberUpdater.update(memberModify.password.toEncrypt(),member)
        memberCategoryUpdater.update(memberModify.categoryRegisters,member.memberId)
    }

    fun suggestRestaurant(email: String):List<Restaurant> =
            memberCategoryReader.findCategoryList(email).categoryRegisters.flatMap {
                category ->
                restaurantReader.findAllByRestaurantType(category.categoryName)
            }.shuffled().take(4)
}