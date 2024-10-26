package io.junseok.domain.noteroom

import io.junseok.domain.member.Member

data class NoteRoom(
    val principal: Member,
    val opponent: Member,
    val note: String?=""
)
