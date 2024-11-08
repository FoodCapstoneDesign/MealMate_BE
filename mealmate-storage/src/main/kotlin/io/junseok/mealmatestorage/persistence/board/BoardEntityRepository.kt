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
    private val boardQueryRepository: BoardQueryRepository
) : BoardRepository {
    @Transactional
    override fun save(board: Board): Long =
        boardEntityJpaRepository.save(board.toEntity()).boardId!!

    /**
     * TODO
     * QuesyDsl로 의존변경
     */
    @Transactional(readOnly = true)
    override fun findAllByOrderByCreateDtDesc(
        page: Int,
        size: Int,
        department: String,
    ): Page<Board> =
        boardQueryRepository.findAllByOrderByCreateDtDesc(PageRequest.of(page, size),department)
            .toDomainByPaging()

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

    @Transactional(readOnly = true)
    override fun findAllByRestaurantOrderByCreateDtDesc(
        page: Int,
        size: Int,
        restaurant: Restaurant,
    ): Page<Board> =
        boardEntityJpaRepository.findAllByRestaurantOrderByCreateDtDesc(
            PageRequest.of(page, size), restaurant.toEntity()
        ).toDomainByPaging()

    @Transactional
    override fun updateRecruitment(board: Board) {
        val boardEntity = (boardEntityJpaRepository.findByIdOrNull(board.boardId)
            ?: throw MealMateException(ErrorCode.NOT_EXIST_BOARD))
        boardEntity.updateRecruitment(!board.isRecruitment!!)
    }
}