package io.junseok.domain.membercategory.serviceimpl

import io.junseok.domain.membercategory.CategoryRegisters
import io.junseok.domain.membercategory.MemberCategoryRepository
import org.springframework.stereotype.Component

@Component
class MemberCategoryCreator(
    private val memberCategoryRepository: MemberCategoryRepository
) {
    fun generate(categoryRegisters: CategoryRegisters,memberId: Long) =
        memberCategoryRepository.save(categoryRegisters,memberId)
}