package io.junseok.domain.noteroommember

import io.junseok.domain.member.serviceimpl.MemberReader
import org.springframework.stereotype.Component

@Component
class NoteRoomMemberReader(
    private val noteRoomMemberRepository: NoteRoomMemberRepository,
    private val memberReader: MemberReader,
) {
    fun findNoteRooms(email: String):List<NoteRoomMemberInfo> {
        val member = memberReader.findMember(email)
        return noteRoomMemberRepository.findAllByMember(member)
    }
}