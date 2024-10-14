package io.junseok.domain.membercategory.serviceimpl

import io.junseok.domain.membercategory.MemberCategoryRepository
import org.springframework.stereotype.Component

@Component
class MemberCategoryReader(
    private val memberCategoryRepository: MemberCategoryRepository
) {
    fun findCategoryList(email: String) = memberCategoryRepository.findAllByMember(email)

}