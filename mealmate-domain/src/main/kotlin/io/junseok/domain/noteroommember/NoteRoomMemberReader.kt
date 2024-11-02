package io.junseok.domain.noteroommember

import io.junseok.domain.member.Member
import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.domain.note.NoteReader
import io.junseok.domain.noteroom.NoteRoom
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

    fun findNoteRoomByMember(noteRoom: NoteRoom, member: Member):Long {
        val opponentNickname =
            noteRoomMemberRepository.findByNoteRoomAndMember(noteRoom, member)
        return memberReader.findMemberByNickname(opponentNickname)
    }
}