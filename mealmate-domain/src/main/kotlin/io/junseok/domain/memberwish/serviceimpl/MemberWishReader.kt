package io.junseok.domain.memberwish.serviceimpl

import io.junseok.domain.member.Member
import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.domain.memberwish.MemberWish
import io.junseok.domain.memberwish.MemberWishRepository
import org.springframework.stereotype.Component

@Component
class MemberWishReader(
    private val memberWishRepository: MemberWishRepository,
    private val memberReader: MemberReader
) {
    fun findWishList(member: Member):List<MemberWish> = memberWishRepository.findAllMember(member)

    fun getWishListCount(email: String): Int{
        val member = memberReader.findMember(email)
        return memberWishRepository.countByMember(member)
    }
}