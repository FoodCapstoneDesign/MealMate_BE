package io.junseok.mealmatestorage.persistence.note

import io.junseok.domain.noteroom.NoteRoom
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.noteroom.NoteRoomEntity

fun NoteRoom.toEntity() = NoteRoomEntity(
    principalEntity = this.principal.toEntity(),
    opponentEntity = this.opponent.toEntity()
)