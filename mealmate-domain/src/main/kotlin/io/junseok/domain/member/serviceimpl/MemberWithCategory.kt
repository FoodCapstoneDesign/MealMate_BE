package io.junseok.domain.member.serviceimpl

import io.junseok.domain.member.Member
import io.junseok.domain.membercategory.CategoryRegisters

data class MemberWithCategory(
    val member: Member,
    val categoryRegisters: CategoryRegisters
)
