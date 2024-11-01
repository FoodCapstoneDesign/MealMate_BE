package io.junseok.mealmatestorage.persistence.board

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class BoardQueryRepository(
    private val em: EntityManager,
) {
    var boardEntity: QBoardEntity = QBoardEntity.boardEntity

    fun findAllByOrderByCreateDtDesc(
        pageable: Pageable,
        department: String,
    ): Page<BoardEntity> {
        val queryFactory = JPAQueryFactory(em)
        val boardList = queryFactory.selectFrom(boardEntity)
            .where(departmentLike(department))
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())

        val content = boardList.fetch()

        val total = queryFactory.selectFrom(boardEntity)
            .where(departmentLike(department))
            .fetchCount()

        return PageImpl(content, pageable, total)
    }

    private fun departmentLike(department: String) =
        if (department.isNotEmpty()) boardEntity.member.department.eq(department) else null
}