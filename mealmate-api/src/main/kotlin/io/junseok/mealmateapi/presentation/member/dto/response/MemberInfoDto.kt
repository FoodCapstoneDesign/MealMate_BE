package io.junseok.mealmateapi.presentation.member.dto.response;

import io.junseok.domain.member.serviceimpl.MemberWithCategory
import io.junseok.mealmateapi.presentation.membercategory.dto.request.MemberCategoryResponse
import io.junseok.mealmateapi.presentation.membercategory.dto.request.MemberCategoryResponse.Companion.toResponse


data class MemberInfoDto(
    val email: String,
    val password: String,
    val nickname: String,
    val studentNumber: String,
    val school: String,
    val department: String,
    val categoryList: List<MemberCategoryResponse>
) {
    companion object {
        fun MemberWithCategory.fromMember() = MemberInfoDto(
            email = this.member.email,
            password = this.member.password,
            nickname = this.member.nickname,
            studentNumber = this.member.studentNumber,
            school = this.member.school,
            department = this.member.department,
            categoryList = this.categoryRegisters.toResponse()
        )
    }
}