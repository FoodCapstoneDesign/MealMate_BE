package io.junseok.domain.member.serviceimpl

import io.junseok.domain.member.MemberRepository
import io.junseok.domain.member.MemberSignUp
import org.springframework.stereotype.Component

@Component
class MemberCreator(
    private val memberRepository: MemberRepository
) {
    fun generate(memberSignUp: MemberSignUp) = memberRepository.save(memberSignUp)
}