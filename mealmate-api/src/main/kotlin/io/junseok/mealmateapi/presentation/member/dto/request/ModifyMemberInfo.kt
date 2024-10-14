package io.junseok.mealmateapi.presentation.member.dto.request

import io.junseok.domain.member.MemberModify
import io.junseok.mealmateapi.presentation.membercategory.dto.request.MemberCategoryRequest
import io.junseok.mealmateapi.presentation.membercategory.dto.request.MemberCategoryRequest.Companion.toCategoryRegisters

data class ModifyMemberInfo(
    val password: String,
    val categoryRegisters: List<MemberCategoryRequest>,
) {
    companion object {
        fun ModifyMemberInfo.toMemberModify() = MemberModify(
            password = this.password,
            categoryRegisters = this.categoryRegisters.toCategoryRegisters()
        )
    }
}
