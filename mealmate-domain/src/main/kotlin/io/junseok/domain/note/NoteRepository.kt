package io.junseok.domain.note

import io.junseok.domain.noteroom.NoteRoom

interface NoteRepository {
    fun save(note: Note): Long?
    fun findByNoteRoom(noteRoom: NoteRoom):List<NoteInfo>
}