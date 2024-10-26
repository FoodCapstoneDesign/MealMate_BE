package io.junseok.domain.note

import org.springframework.stereotype.Service

@Service
class NoteService(
    private val noteCreator: NoteCreator,
    private val noteReader: NoteReader
) {
    fun transmitNote(note: Note, email: String): Long? =
        noteCreator.generate(note, email)

    fun showAllNotes(noteRoomId: Long):List<NoteInfo> =
        noteReader.findNotes(noteRoomId)

}