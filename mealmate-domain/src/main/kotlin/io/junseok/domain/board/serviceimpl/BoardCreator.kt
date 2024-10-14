package io.junseok.domain.board.serviceimpl

import io.junseok.domain.board.Board
import io.junseok.domain.board.BoardRepository
import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import org.springframework.stereotype.Component

@Component
class BoardCreator(
    private val boardRepository: BoardRepository,
    private val memberReader: MemberReader,
    private val restaurantReader: RestaurantReader,
) {
    fun create(board: Board, restaurantId: Long, email: String): Long {
        val member = memberReader.findMember(email)
        val restaurant = restaurantReader.findById(restaurantId)
        return boardRepository.save(
            Board(
                title = board.title,
                content = board.content,
                member = member,
                restaurant = restaurant
            )
        )
    }
}