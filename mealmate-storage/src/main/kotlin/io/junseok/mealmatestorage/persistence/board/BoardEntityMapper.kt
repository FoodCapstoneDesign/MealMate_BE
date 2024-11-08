package io.junseok.mealmatestorage.persistence.board

import io.junseok.domain.board.Board
import io.junseok.mealmatestorage.persistence.member.toDomain
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.restaurant.toDomain
import io.junseok.mealmatestorage.persistence.restaurant.toEntity
import io.junseok.page.PageImpl
import org.springframework.data.domain.Page

fun Board.toEntity() = BoardEntity(
    title = this.title,
    content = this.content,
    member = this.member!!.toEntity(),
    restaurant = this.restaurant!!.toEntity(),
    isRecruitment = this.isRecruitment!!
)

fun BoardEntity.toDomain() = Board(
    title = this.title,
    content = this.content,
    boardId = this.boardId,
    lastTime = this.createDt,
    modifyDt = this.modifyDt,
    restaurant = this.restaurant.toDomain(),
    member = this.member.toDomain(),
    isRecruitment = this.isRecruitment
)

fun Page<BoardEntity>.toDomainByPaging() = PageImpl(
    content = this.content.map { it.toDomain() },
    totalPage = this.totalPages,
    totalElement = this.totalElements
)