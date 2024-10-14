package io.junseok.domain.member

import io.junseok.domain.membercategory.CategoryRegisters

data class MemberModify(
    val password: String,
    val categoryRegisters: CategoryRegisters
)
