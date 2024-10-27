package io.junseok.mealmatestorage.persistence.noteroom

import io.junseok.domain.noteroom.NoteRoom

fun String.toEntityByNickname()=NoteRoomEntity(
    creator = this
)

fun NoteRoomEntity.toDomain()=NoteRoom(
    roomId = this.noteRoomId!!,
    creator = this.creator
)

fun NoteRoom.toEntity()=NoteRoomEntity(
    noteRoomId = this.roomId,
    creator = this.creator
)