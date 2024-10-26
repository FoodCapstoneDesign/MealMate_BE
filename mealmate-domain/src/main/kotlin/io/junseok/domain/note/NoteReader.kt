package io.junseok.domain.note

import io.junseok.domain.noteroom.NoteRoomReader
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
}