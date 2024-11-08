package io.junseok.domain.board

import io.junseok.domain.restaurant.Restaurant
import io.junseok.page.Page

interface BoardRepository {
    fun save(board: Board): Long
    fun findAllByOrderByCreateDtDesc(page: Int, size: Int, department: String): Page<Board>
    fun findById(boardId: Long): Board
    fun deleteById(boardId: Long)
    fun update(boardId: Long, board: Board): Long
    fun findAllByRestaurantOrderByCreateDtDesc(
        page: Int,
        size: Int,
        restaurant: Restaurant,
    ): Page<Board>

    fun updateRecruitment(board: Board)
}