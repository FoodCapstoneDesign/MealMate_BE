package io.junseok.mealmatestorage.persistence.note

import org.springframework.data.jpa.repository.JpaRepository

interface NoteJpaRepository : JpaRepository<NoteEntity,Long> {
}