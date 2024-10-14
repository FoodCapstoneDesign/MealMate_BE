package io.junseok.domain.member.serviceimpl

import io.junseok.domain.member.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberReader(
    private val memberRepository: MemberRepository
) {
    fun findMember(email: String) = memberRepository.findByEmail(email)
}