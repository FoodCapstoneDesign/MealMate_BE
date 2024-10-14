package io.junseok.domain.member.serviceimpl

import io.junseok.domain.member.Member
import io.junseok.domain.member.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberUpdater(private val memberRepository: MemberRepository) {
    fun update(password: String, member: Member) {
        val modifyMember = Member(
            memberId = member.memberId,
            email = member.email,
            password = password,
            nickname = member.nickname,
            school = member.school,
            studentNumber = member.studentNumber,
            department = member.department,
            activated = member.activated,
            authority = member.authority
        )
        memberRepository.update(modifyMember)
    }
}