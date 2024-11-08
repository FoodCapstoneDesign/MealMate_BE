package io.junseok.domain.board.serviceimpl

import io.junseok.domain.board.Board
import io.junseok.domain.board.BoardRepository
import io.junseok.domain.member.serviceimpl.MemberReader
import org.springframework.stereotype.Component

@Component
class BoardUpdater(
    private val boardRepository: BoardRepository,
    private val boardReader: BoardReader,
    private val boardValidator: BoardValidator
) {
    fun update(boardId: Long, board: Board): Long =
        boardRepository.update(boardId, board)

    fun recruitmentStatus(boardId: Long, email: String) {
        val board = boardReader.findBoard(boardId)
        boardValidator.isWriter(email,board)
        boardRepository.updateRecruitment(board)
    }
}