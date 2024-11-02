package io.junseok.mealmateapi.presentation.note.dto.response

import io.junseok.domain.note.NoteInfo
import java.time.LocalDateTime

// TODO -> NoteOpponentResponse DTO 분리 후 단일 객체로 반환
data class NoteResponse(
    val message: String,
    val sendDt: LocalDateTime,
    val email: String,
    val opponentId: Long?=0
){
    companion object{
        fun NoteInfo.fromDomain()=NoteResponse(
            message = this.message,
            sendDt = this.sendDt,
            email = this.email,
            opponentId = this.opponentId
        )
    }
}
