package io.junseok.domain.board.serviceimpl

import io.junseok.domain.board.Board
import io.junseok.domain.board.BoardRepository
import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import io.junseok.page.Page
import org.springframework.stereotype.Component

@Component
class BoardReader(
    private val boardRepository: BoardRepository,
    private val restaurantReader: RestaurantReader
    ) {
    fun findBoardList(page: Int, size:Int, department: String): Page<Board> =
        boardRepository.findAllByOrderByCreateDtDesc(page,size, department)

    fun findBoard(boardId: Long) = boardRepository.findById(boardId)

    fun findBoardByRestaurant(restaurantId: Long, page: Int,size: Int): Page<Board>{
        val restaurant = restaurantReader.findById(restaurantId)
        return boardRepository.findAllByRestaurantOrderByCreateDtDesc(page, size, restaurant)
    }
}