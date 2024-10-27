package io.junseok.domain.note

import io.junseok.domain.noteroom.NoteRoom
import io.junseok.domain.noteroommember.NoteRoomMemberInfo

interface NoteRepository {
    fun save(note: Note): Long?
    fun findByNoteRoom(noteRoom: NoteRoom):List<NoteInfo>

    fun findAllByNoteRoomForLastNote(noteRoom: NoteRoom):NoteRoomMemberInfo
}