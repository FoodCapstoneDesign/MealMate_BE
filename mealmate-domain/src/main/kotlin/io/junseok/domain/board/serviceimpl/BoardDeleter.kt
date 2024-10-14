package io.junseok.domain.board.serviceimpl

import io.junseok.domain.board.BoardRepository
import org.springframework.stereotype.Component

@Component
class BoardDeleter(
    private val boardRepository: BoardRepository
) {
    fun delete(boardId: Long) = boardRepository.deleteById(boardId)
}