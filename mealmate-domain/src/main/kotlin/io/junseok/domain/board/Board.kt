package io.junseok.domain.board

import io.junseok.domain.member.Member
import io.junseok.domain.restaurant.Restaurant
import java.time.LocalDateTime

data class Board(
    val title: String,
    val content: String,
    val boardId: Long?=null,
    val lastTime: LocalDateTime?=null,
    val modifyDt: LocalDateTime?=null,
    val restaurant: Restaurant? =null,
    val member: Member? =null
)
