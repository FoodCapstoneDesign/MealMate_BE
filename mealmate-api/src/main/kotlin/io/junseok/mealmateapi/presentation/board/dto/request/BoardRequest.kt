package io.junseok.mealmateapi.presentation.board.dto.request

import io.junseok.domain.board.Board

data class BoardRequest(
    val title: String,
    val content: String,
    val restaurantId: Long
){
    companion object{
        fun BoardRequest.toDomain()=Board(
            title = title,
            content = content
        )
    }
}