package io.junseok.domain.noteroom

import org.springframework.stereotype.Component

@Component
class NoteRoomCreator(private val roomRepository: NoteRoomRepository) {
    fun create(noteRoom: NoteRoom): Long = roomRepository.save(noteRoom)
}