package io.junseok.mealmatestorage.persistence.member

import io.junseok.domain.member.Member
import io.junseok.domain.member.MemberSignUp

fun MemberEntity.toDomain()=Member(
    memberId = this.memberId!!,
    email = this.email,
    password = this.password,
    nickname = this.nickname,
    school = this.school,
    studentNumber = this.studentNumber,
    department = this.department,
    activated = this.activated,
    authority = this.authority.name,
)

fun Member.toEntity()=MemberEntity(
    memberId = this.memberId,
    email = this.email,
    password = this.password,
    nickname = this.nickname,
    school = this.school,
    studentNumber = this.studentNumber,
    department = this.department,
    activated = this.activated,
    authority = Authority.valueOf(this.authority)
)

fun MemberSignUp.toEntity()=MemberEntity(
    email = this.email,
    password = this.password,
    nickname = this.nickname,
    school = this.school,
    studentNumber = this.studentNumber,
    department = this.department,
    authority = Authority.ROLE_USER,
    activated = true
)