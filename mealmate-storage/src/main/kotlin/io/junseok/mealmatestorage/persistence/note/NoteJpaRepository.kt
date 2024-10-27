package io.junseok.mealmatestorage.persistence.note

import io.junseok.mealmatestorage.persistence.noteroom.NoteRoomEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NoteJpaRepository : JpaRepository<NoteEntity,Long> {
    fun findAllByNoteRoom(noteRoomEntity: NoteRoomEntity):List<NoteEntity>

    fun findTopByNoteRoomOrderByCreateDtDesc(noteRoomEntity: NoteRoomEntity): NoteEntity
}