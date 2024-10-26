package io.junseok.domain.note

import io.junseok.domain.member.Member
import io.junseok.domain.noteroom.NoteRoom

data class Note(
    val message: String,
    val sender: Member?=null,
    val receiver: Member?=null,
    val opponentId:Long? =null,
    val noteRoomId:Long?=null,
    val noteRoom: NoteRoom?=null
)
