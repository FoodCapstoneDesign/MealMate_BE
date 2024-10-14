package io.junseok.domain.auth

import io.junseok.domain.member.MemberRepository
import org.springframework.stereotype.Component

@Component
class CustomUserDetailsService(
    private val memberRepository: MemberRepository,
) {
    fun findAuthorityMember(email: String) = memberRepository.findOneWithAuthoritiesByEmail(email)
}
