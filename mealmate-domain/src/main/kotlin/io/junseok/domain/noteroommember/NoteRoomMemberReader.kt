package io.junseok.domain.noteroommember

import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.domain.note.NoteReader
import io.junseok.domain.noteroom.NoteRoomReader
import org.springframework.stereotype.Component

@Component
class NoteRoomMemberReader(
    private val noteRoomMemberRepository: NoteRoomMemberRepository,
    private val memberReader: MemberReader,
    private val noteReader: NoteReader
) {
    fun findNoteRooms(email: String): List<NoteRoomMemberInfo> {
        val member = memberReader.findMember(email)
        val roomInfoList =
            noteRoomMemberRepository.findAllByMember(member)
        return noteReader.findNoteByMember(roomInfoList)
    }
}