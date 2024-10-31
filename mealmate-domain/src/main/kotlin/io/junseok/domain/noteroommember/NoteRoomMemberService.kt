package io.junseok.domain.noteroommember

import io.junseok.domain.member.serviceimpl.MemberReader
import org.springframework.stereotype.Service

@Service
class NoteRoomMemberService(
    private val memberReader: MemberReader,
    private val noteRoomMemberProcessor: NoteRoomMemberProcessor,
    private val noteRoomMemberDeleter: NoteRoomMemberDeleter,
    private val noteRoomMemberReader: NoteRoomMemberReader,
    private val noteRoomMemberValidator: NoteRoomMemberValidator,
) {
    fun generateRoom(opponentId: Long, email: String): Long {
        val member = memberReader.findMember(email)
        val opponent = memberReader.findMemberById(opponentId)
        return noteRoomMemberValidator.isExistNoteRoom(member, opponent).takeIf { it != null }
            ?: noteRoomMemberProcessor.createTwoRoom(member, opponent)
    }

    fun deleteRoom(email: String) {
        val member = memberReader.findMember(email)
        noteRoomMemberDeleter.delete(member)
    }

    fun getRoomList(email: String): List<NoteRoomMemberInfo> =
        noteRoomMemberReader.findNoteRooms(email)
}