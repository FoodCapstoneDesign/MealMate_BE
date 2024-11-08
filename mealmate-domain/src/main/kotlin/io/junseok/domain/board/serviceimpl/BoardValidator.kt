package io.junseok.domain.board.serviceimpl

import io.junseok.domain.board.Board
import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Component

@Component
class BoardValidator(private val memberReader: MemberReader) {
    fun isWriter(email: String,board: Board){
        val member = memberReader.findMember(email)
        if(member.memberId != board.member!!.memberId)
            throw MealMateException(ErrorCode.NOT_WRITE_MEMBER)
    }
}