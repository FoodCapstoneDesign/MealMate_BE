package io.junseok.domain.noteroommember

import io.junseok.domain.member.Member

interface NoteRoomMemberRepository {
    fun save(noteRoomMember: NoteRoomMember): Long
    fun delete(member: Member)
    fun findAllByMember(member: Member):List<NoteRoomMemberInfo>
}