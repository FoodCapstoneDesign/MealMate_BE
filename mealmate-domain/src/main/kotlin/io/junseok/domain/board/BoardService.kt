package io.junseok.domain.board

import io.junseok.domain.board.serviceimpl.BoardCreator
import io.junseok.domain.board.serviceimpl.BoardDeleter
import io.junseok.domain.board.serviceimpl.BoardReader
import io.junseok.domain.board.serviceimpl.BoardUpdater
import io.junseok.page.Page
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardCreator: BoardCreator,
    private val boardReader: BoardReader,
    private val boardDeleter: BoardDeleter,
    private val boardUpdater: BoardUpdater
) {
    fun createBoard(
        board: Board,
        restaurantId: Long,
        email: String,
    ): Long = boardCreator.create(board, restaurantId, email)

    fun showBoardList(page: Int, size: Int, department: String): Page<Board> =
        boardReader.findBoardList(page,size,department)

    fun getBoard(boardId: Long) = boardReader.findBoard(boardId)

    fun remove(boardId: Long) = boardDeleter.delete(boardId)

    fun modifyBoard(boardId: Long,board: Board) = boardUpdater.update(boardId,board)

    fun getBoardByRestaurant(restaurantId: Long,page: Int,size: Int): Page<Board> =
        boardReader.findBoardByRestaurant(restaurantId,page, size)
}