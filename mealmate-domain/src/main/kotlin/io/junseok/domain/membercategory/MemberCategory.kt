package io.junseok.domain.membercategory

import io.junseok.domain.member.Member

data class MemberCategory(
    val categoryName: String,
    val member: Member
)
