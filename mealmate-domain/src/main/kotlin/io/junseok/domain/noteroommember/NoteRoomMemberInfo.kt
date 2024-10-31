package io.junseok.domain.noteroommember

import java.time.LocalDateTime

data class NoteRoomMemberInfo(
    val noteRoomId: Long,
    val roomName: String,
    val message: String,
    val sendDt: LocalDateTime
)
