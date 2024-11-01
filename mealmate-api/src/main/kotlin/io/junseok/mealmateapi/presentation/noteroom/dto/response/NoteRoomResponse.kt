package io.junseok.mealmateapi.presentation.noteroom.dto.response

import io.junseok.domain.noteroommember.NoteRoomMemberInfo
import java.time.LocalDateTime

data class NoteRoomResponse(
    val roomId:Long,
    val roomName: String,
    val message: String,
    val sendDt: LocalDateTime
){
    companion object{
        fun NoteRoomMemberInfo.toNoteRoomResponse()=NoteRoomResponse(
            roomId = this.noteRoomId,
            roomName = this.roomName,
            message = this.message,
            sendDt = this.sendDt
        )
    }
}
