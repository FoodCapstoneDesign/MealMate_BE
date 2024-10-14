package io.junseok.domain.board.serviceimpl

import io.junseok.domain.board.Board
import io.junseok.domain.board.BoardRepository
import org.springframework.stereotype.Component

@Component
class BoardUpdater(
    private val boardRepository: BoardRepository,
) {
    fun update(boardId: Long, board: Board): Long =
        boardRepository.update(boardId, board)
}