package io.junseok.domain.memberwish.serviceimpl

import io.junseok.domain.memberwish.MemberWishRepository
import org.springframework.stereotype.Component

@Component
class MemberWishDeleter(private val memberWishRepository: MemberWishRepository) {
    fun delete(wishListId: Long) = memberWishRepository.deleteById(wishListId)
}