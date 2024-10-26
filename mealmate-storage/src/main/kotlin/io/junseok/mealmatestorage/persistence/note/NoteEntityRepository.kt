package io.junseok.mealmatestorage.persistence.note

import org.springframework.stereotype.Repository

@Repository
class NoteEntityRepository(
    private val noteJpaRepository: NoteJpaRepository,
) {
}