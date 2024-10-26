package io.junseok.domain.noteroom

import io.junseok.domain.member.Member
import org.springframework.stereotype.Component

@Component
class NoteRoomDeleter(
    private val noteRoomRepository: NoteRoomRepository
) {
    fun delete(member: Member) = noteRoomRepository.delete(member)
}