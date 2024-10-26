package io.junseok.domain.noteroommember

import io.junseok.domain.member.Member
import io.junseok.domain.noteroom.NoteRoom

data class NoteRoomMember(
    val principal: Member,
    val opponent: Member,
    val note: String?="",
    val noteRoom: NoteRoom
)
