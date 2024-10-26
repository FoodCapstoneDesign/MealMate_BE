package io.junseok.domain.noteroommember

import io.junseok.domain.member.Member
import io.junseok.domain.noteroom.NoteRoomCreator
import org.springframework.stereotype.Component

@Component
class NoteRoomMemberProcessor(
    private val noteRoomMemberCreator: NoteRoomMemberCreator,
    private val noteRoomCreator: NoteRoomCreator,
) {
    fun createTwoRoom(member: Member, opponent: Member): Long {
        val noteRoom = noteRoomCreator.create(member.nickname)
        val myRoodId = noteRoomMemberCreator.create(
            NoteRoomMember(
                principal = member,
                opponent = opponent,
                noteRoom = noteRoom
            )
        )
        noteRoomMemberCreator.create(
            NoteRoomMember(
                principal = opponent,
                opponent = member,
                noteRoom = noteRoom
            )
        )
        return myRoodId
    }
}