package io.junseok.mealmateapi.presentation.note.dto.response

import io.junseok.domain.note.NoteInfo
import java.time.LocalDateTime

data class NoteResponse(
    val message: String,
    val sendDt: LocalDateTime,
    val email: String
){
    companion object{
        fun NoteInfo.fromDomain()=NoteResponse(
            message = this.message,
            sendDt = this.sendDt,
            email = this.email
        )
    }
}
