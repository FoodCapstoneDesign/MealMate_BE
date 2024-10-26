package io.junseok.domain.noteroommember

import java.time.LocalDateTime

data class NoteRoomMemberInfo(
    val roomName: String,
    val message: String,
    val sendDt: LocalDateTime
)
