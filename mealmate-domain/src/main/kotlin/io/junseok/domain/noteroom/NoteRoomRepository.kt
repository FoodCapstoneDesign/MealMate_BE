package io.junseok.domain.noteroom

import io.junseok.domain.member.Member

interface NoteRoomRepository {
    fun save(noteRoom: NoteRoom): Long
    fun delete(member: Member)
}