package io.junseok.domain.auth

import io.junseok.domain.member.MemberRepository
import org.springframework.stereotype.Component

@Component
class LoginAuthService(
    private val memberRepository: MemberRepository
) {
    fun findMemberByEmail(email: String) = memberRepository.findByEmail(email)
}
