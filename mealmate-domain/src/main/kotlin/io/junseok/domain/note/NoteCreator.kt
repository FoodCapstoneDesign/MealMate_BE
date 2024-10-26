package io.junseok.domain.note

import io.junseok.domain.member.serviceimpl.MemberReader
import io.junseok.domain.noteroom.NoteRoomReader
import org.springframework.stereotype.Component

@Component
class NoteCreator(
    private val noteRepository: NoteRepository,
    private val memberReader: MemberReader,
    private val noteRoomReader: NoteRoomReader,
) {
    fun generate(note: Note, email: String):Long? {
        val sender = memberReader.findMember(email)
        val receiver = memberReader.findMemberById(note.opponentId!!)
        val noteRoom = noteRoomReader.findNoteRoomByID(note.noteRoomId!!)
        return noteRepository.save(
            Note(
                message = note.message,
                sender = sender,
                receiver = receiver,
                noteRoom = noteRoom
            )
        )
    }
}