package io.junseok.domain.noteroom

import io.junseok.domain.member.Member
import org.springframework.stereotype.Component

@Component
class NoteRoomProcessor(
    private val noteRoomCreator: NoteRoomCreator
) {
    fun createTwoRoom(member: Member,opponent: Member): Long{
        val myRoodId = noteRoomCreator.create(
            NoteRoom(
                principal = member,
                opponent = opponent
            )
        )
        noteRoomCreator.create(
            NoteRoom(
                principal = opponent,
                opponent = member
            )
        )
        return myRoodId
    }
}