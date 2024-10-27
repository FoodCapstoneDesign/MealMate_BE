package io.junseok.domain.note

import io.junseok.domain.member.Member
import io.junseok.domain.noteroom.NoteRoom
import io.junseok.domain.noteroom.NoteRoomReader
import io.junseok.domain.noteroommember.NoteRoomMemberInfo
import org.springframework.stereotype.Component

@Component
class NoteReader(
    private val noteRepository: NoteRepository,
    private val noteRoomReader: NoteRoomReader
) {
    fun findNotes(noteRoomId: Long):List<NoteInfo>{
        val noteRoom = noteRoomReader.findNoteRoomByID(noteRoomId)
        return noteRepository.findByNoteRoom(noteRoom)
    }
    fun findNoteByMember(roomList: List<NoteRoom>):List<NoteRoomMemberInfo>{
        return roomList.map {
            noteRepository.findAllByNoteRoomForLastNote(it)
        }
    }
}