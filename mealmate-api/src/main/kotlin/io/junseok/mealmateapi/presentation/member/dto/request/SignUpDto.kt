package io.junseok.mealmateapi.presentation.member.dto.request;

import io.junseok.domain.member.MemberSignUp
import io.junseok.mealmateapi.presentation.membercategory.dto.request.MemberCategoryRequest
import io.junseok.mealmateapi.presentation.membercategory.dto.request.MemberCategoryRequest.Companion.toCategoryRegisters
import io.junseok.toEncrypt

data class SignUpDto(
    val email: String,
    val password: String,
    val nickname: String,
    val school: String,
    val studentNumber: String,
    val department: String,
    val categoryRegisters: List<MemberCategoryRequest>
){
    companion object {
        const val USER_AUTHORITY = "ROLE_USER"
        fun SignUpDto.toMemberSignUp() = MemberSignUp(
            email = this.email,
            password = this.password.toEncrypt(),
            nickname = this.nickname,
            school = this.school,
            studentNumber = this.studentNumber,
            department = this.department,
            authority = USER_AUTHORITY,
            categoryRegisters = this.categoryRegisters.toCategoryRegisters()
        )
    }
}