package io.junseok.domain.member.serviceimpl

import io.junseok.domain.member.MemberRepository
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Component
import java.util.regex.Pattern

@Component
class MemberValidator(
    private val memberRepository: MemberRepository,
) {
    fun validEmail(email: String) {
        if (memberRepository.existsByEmail(email)) {
            throw MealMateException(ErrorCode.EXIST_EMAIL)
        }
    }

    companion object {
        private val EMAIL_PATTERN: Pattern =
            Pattern.compile("^[a-zA-Z0-9._%+-]{2,}+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")

        fun valid(email: String) {
            if (!EMAIL_PATTERN.matcher(email).matches()) {
                throw MealMateException(ErrorCode.INVALID_EMAIL_FORMAT)
            }
        }
    }
}