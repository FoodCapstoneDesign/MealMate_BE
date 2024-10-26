package io.junseok.domain.noteroom

import io.junseok.domain.member.serviceimpl.MemberReader
import org.springframework.stereotype.Service

@Service
class NoteRoomService(
    private val memberReader: MemberReader,
    private val noteRoomProcessor: NoteRoomProcessor,
    private val noteRoomDeleter: NoteRoomDeleter
) {
    fun generateRoom(opponentId: Long, email: String): Long {
        val member = memberReader.findMember(email)
        val opponent = memberReader.findMemberById(opponentId)
        return noteRoomProcessor.createTwoRoom(member,opponent)
    }

    fun deleteRoom(email: String){
        val member = memberReader.findMember(email)
        noteRoomDeleter.delete(member)
    }
}