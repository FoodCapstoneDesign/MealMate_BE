package io.junseok.mealmatestorage.persistence.board

import io.junseok.domain.board.Board
import io.junseok.domain.board.BoardRepository
import io.junseok.domain.restaurant.Restaurant
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import io.junseok.mealmatestorage.persistence.restaurant.toEntity
import io.junseok.page.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class BoardEntityRepository(
    private val boardEntityJpaRepository: BoardEntityJpaRepository,
) : BoardRepository {
    @Transactional
    override fun save(board: Board): Long =
        boardEntityJpaRepository.save(board.toEntity()).boardId!!

    @Transactional(readOnly = true)
    override fun findAllByOrderByCreateDtDesc(page: Int, size: Int): Page<Board> =
        boardEntityJpaRepository.findAllByOrderByCreateDtDesc(PageRequest.of(page,size)).toDomainByPaging()

    @Transactional(readOnly = true)
    override fun findById(boardId: Long) =
        boardEntityJpaRepository.findByIdOrNull(boardId)?.toDomain()
            ?: throw MealMateException(ErrorCode.NOT_EXIST_BOARD)

    @Transactional
    override fun deleteById(boardId: Long) = boardEntityJpaRepository.deleteById(boardId)

    @Transactional
    override fun update(boardId: Long, board: Board): Long {
        boardEntityJpaRepository.findByIdOrNull(boardId)
            ?.updateBoard(board)
        return boardId
    }

    override fun findAllByRestaurantOrderByCreateDtDesc(
        page: Int,
        size: Int,
        restaurant: Restaurant,
    ): Page<Board> =
        boardEntityJpaRepository.findAllByRestaurantOrderByCreateDtDesc(
            PageRequest.of(page, size),restaurant.toEntity()
        ).toDomainByPaging()
}