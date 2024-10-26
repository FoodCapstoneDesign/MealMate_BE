package io.junseok.domain.noteroom

import org.springframework.stereotype.Component

@Component
class NoteRoomCreator(
    private val noteRoomRepository: NoteRoomRepository
) {
    fun create(nickName: String):NoteRoom =
        noteRoomRepository.save(nickName)

}