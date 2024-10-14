package io.junseok.domain.member.serviceimpl

import io.junseok.domain.member.Member
import io.junseok.domain.member.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberDeleter(
    private val memberRepository: MemberRepository
) {
    fun delete(email: String) = memberRepository.delete(email)
}