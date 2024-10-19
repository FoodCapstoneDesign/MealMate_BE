package io.junseok.domain.member.serviceimpl

import io.junseok.domain.member.MemberRepository
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Component

@Component
class MemberReader(
    private val memberRepository: MemberRepository
) {
    fun findMember(email: String) = memberRepository.findByEmail(email)
        ?: throw MealMateException(ErrorCode.NOT_EXIST_MEMBER)
}