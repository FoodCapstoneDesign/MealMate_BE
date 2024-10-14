package io.junseok.domain.membercategory.serviceimpl

import io.junseok.domain.membercategory.CategoryRegisters
import org.springframework.stereotype.Component

@Component
class MemberCategoryUpdater(
    private val memberCategoryDeleter: MemberCategoryDeleter,
    private val memberCategoryCreator: MemberCategoryCreator
) {
    fun update(categoryRegisters: CategoryRegisters, memberId: Long){
        memberCategoryDeleter.deleteAllCategory(memberId)
        memberCategoryCreator.generate(categoryRegisters,memberId)
    }
}