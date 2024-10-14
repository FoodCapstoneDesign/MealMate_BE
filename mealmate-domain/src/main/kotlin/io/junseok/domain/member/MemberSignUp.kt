package io.junseok.domain.member

import io.junseok.domain.membercategory.CategoryRegisters

data class MemberSignUp(
    val email: String,
    val password: String,
    val nickname: String,
    val school: String,
    val studentNumber: String,
    val department: String,
    val categoryRegisters: CategoryRegisters,
    val authority: String
)