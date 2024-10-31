package io.junseok.domain.noteroommember

import io.junseok.domain.member.Member
import io.junseok.domain.noteroom.NoteRoom

interface NoteRoomMemberRepository {
    fun save(noteRoomMember: NoteRoomMember): Long
    fun delete(member: Member)
    fun findAllByMember(member: Member):List<NoteRoom>
    fun existByNoteRoom(owned: Member, opponent:Member): Long?
}