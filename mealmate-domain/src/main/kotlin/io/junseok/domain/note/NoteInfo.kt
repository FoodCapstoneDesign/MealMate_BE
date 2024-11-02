package io.junseok.domain.note

import java.time.LocalDateTime

data class NoteInfo(
    val message: String,
    val sendDt: LocalDateTime,
    val email: String,
    val opponentId: Long?=0
)
