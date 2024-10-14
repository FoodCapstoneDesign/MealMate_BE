package io.junseok.domain.memberwish.serviceimpl

import io.junseok.domain.memberwish.MemberWish
import io.junseok.domain.memberwish.MemberWishRepository
import org.springframework.stereotype.Component

@Component
class MemberWishCreator(private val memberWishRepository: MemberWishRepository) {
    fun create(memberWish: MemberWish) = memberWishRepository.save(memberWish)
}