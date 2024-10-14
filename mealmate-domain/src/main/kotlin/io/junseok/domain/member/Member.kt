package io.junseok.domain.member

data class Member(
    val memberId: Long,
    val email: String,
    val password: String,
    val nickname: String,
    val school: String,
    val studentNumber: String,
    val department: String,
    val activated: Boolean,
    val authority: String,
)