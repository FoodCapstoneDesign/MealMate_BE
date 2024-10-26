package io.junseok.domain.noteroommember

import org.springframework.stereotype.Component

@Component
class NoteRoomMemberCreator(private val roomRepository: NoteRoomMemberRepository) {
    fun create(noteRoomMember: NoteRoomMember): Long = roomRepository.save(noteRoomMember)
}