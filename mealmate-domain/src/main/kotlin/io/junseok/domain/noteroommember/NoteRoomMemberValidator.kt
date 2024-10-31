package io.junseok.domain.noteroommember

import io.junseok.domain.member.Member
import org.springframework.stereotype.Component

@Component
class NoteRoomMemberValidator(
    private val noteRoomMemberRepository: NoteRoomMemberRepository,
) {
    fun isExistNoteRoom(owned: Member, opponent:Member) =
        noteRoomMemberRepository.existByNoteRoom(owned,opponent)
}