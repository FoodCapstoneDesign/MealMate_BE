package io.junseok.domain.noteroommember

import io.junseok.domain.member.Member
import org.springframework.stereotype.Component

@Component
class NoteRoomMemberDeleter(
    private val noteRoomMemberRepository: NoteRoomMemberRepository
) {
    fun delete(member: Member) = noteRoomMemberRepository.delete(member)
}