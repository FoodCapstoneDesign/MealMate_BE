package io.junseok.mealmateapi.presentation.note.dto.request

import io.junseok.domain.note.Note

data class NoteRequest(
    val message: String,
    val opponentId: Long,
    val noteRoomId: Long,
){
    companion object{
        fun NoteRequest.toDomain()= Note(
            message= this.message,
            opponentId = this.opponentId,
            noteRoomId = this.noteRoomId
        )
    }
}
