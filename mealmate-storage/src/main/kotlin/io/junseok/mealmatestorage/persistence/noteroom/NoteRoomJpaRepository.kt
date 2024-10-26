package io.junseok.mealmatestorage.persistence.noteroom

import org.springframework.data.jpa.repository.JpaRepository

interface NoteRoomJpaRepository: JpaRepository<NoteRoomEntity,Long> {
}