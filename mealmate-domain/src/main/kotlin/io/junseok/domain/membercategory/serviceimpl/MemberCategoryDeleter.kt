package io.junseok.domain.membercategory.serviceimpl

import io.junseok.domain.membercategory.MemberCategoryRepository
import org.springframework.stereotype.Component

@Component
class MemberCategoryDeleter(
    private val memberCategoryRepository: MemberCategoryRepository
) {
    fun deleteAllCategory(memberId: Long){
        memberCategoryRepository.deleteAllByMember(memberId)
    }
}