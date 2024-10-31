package io.junseok.mealmateapi.presentation.board.dto.response

import io.junseok.domain.board.Board
import io.junseok.page.Page
import io.junseok.page.PageImpl
import java.time.LocalDateTime

data class BoardResponse(
    val title: String,
    val content: String,
    val nickname: String,
    val lastTime: LocalDateTime,
    val modifyDt: LocalDateTime,
    val boardId: Long,
    val email: String,
    val writerId: Long
) {
    companion object {
        fun Board.fromBoard() = BoardResponse(
            title = this.title,
            content = this.content,
            nickname = this.member!!.nickname,
            lastTime = this.lastTime!!,
            modifyDt = this.modifyDt!!,
            boardId = this.boardId!!,
            email = this.member!!.email,
            writerId = this.member!!.memberId
        )

        fun Page<Board>.fromBoardByPaging(): Page<BoardResponse> {
            val boardResponses = this.content.map { it.fromBoard() }
            return PageImpl(
                content = boardResponses,
                totalPage = this.totalPage,
                totalElement = this.totalElement
            )
        }
    }
}