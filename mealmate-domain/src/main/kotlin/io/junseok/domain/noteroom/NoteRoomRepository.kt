package io.junseok.domain.noteroom

interface NoteRoomRepository {
    fun save(nickname: String): NoteRoom
    fun findById(noteRoomId: Long):NoteRoom
}