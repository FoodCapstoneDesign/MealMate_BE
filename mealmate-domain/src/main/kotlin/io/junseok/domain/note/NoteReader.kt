package io.junseok.domain.note

import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.domain.noteroom.NoteRoom
import io.junseok.domain.noteroom.NoteRoomReader
import io.junseok.domain.noteroommember.NoteRoomMemberInfo
import io.junseok.domain.noteroommember.NoteRoomMemberRepository
import org.springframework.stereotype.Component

@Component
class NoteReader(
    private val noteRepository: NoteRepository,
    private val noteRoomReader: NoteRoomReader,
    private val memberReader: MemberReader,
    private val noteRoomMemberRepository: NoteRoomMemberRepository,
) {
    fun findNotes(noteRoomId: Long, email: String):List<NoteInfo>{
        val noteRoom = noteRoomReader.findNoteRoomByID(noteRoomId)
        val member = memberReader.findMember(email)
        val opponentNickname =
            noteRoomMemberRepository.findByNoteRoomAndMember(noteRoom, member)
        val opponentId = memberReader.findMemberByNickname(opponentNickname)
        return noteRepository.findByNoteRoom(noteRoom,opponentId)
    }
    fun findNoteByMember(roomList: List<NoteRoom>):List<NoteRoomMemberInfo>{
        return roomList.map {
            noteRepository.findAllByNoteRoomForLastNote(it)
        }
    }
}