package io.junseok.mealmateapi.presentation.note.dto.response

data class NoteOpponentResponse(val opponentId: Long){
    companion object{
        fun Long.toOpponentId()= NoteOpponentResponse(
            opponentId = this
        )
    }
}
