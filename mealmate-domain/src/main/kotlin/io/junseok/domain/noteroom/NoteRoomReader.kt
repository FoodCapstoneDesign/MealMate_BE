package io.junseok.domain.noteroom

import org.springframework.stereotype.Component

@Component
class NoteRoomReader(private val noteRoomRepository: NoteRoomRepository) {
    fun findNoteRoom(noteRoom: NoteRoom) = noteRoomRepository.findById(noteRoom.roomId!!)

    fun findNoteRoomByID(noteRoomId: Long) = noteRoomRepository.findById(noteRoomId)
}