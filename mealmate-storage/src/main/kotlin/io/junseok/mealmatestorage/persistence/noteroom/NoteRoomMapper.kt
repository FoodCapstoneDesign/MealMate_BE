package io.junseok.mealmatestorage.persistence.noteroom

import io.junseok.domain.noteroom.NoteRoom
import kotlin.concurrent.thread

fun String.toEntityByNickname()=NoteRoomEntity(
    nickName = this
)

fun NoteRoomEntity.toDomain()=NoteRoom(
    roomId = this.noteRoomId!!,
    nickname = this.nickName
)

fun NoteRoom.toEntity()=NoteRoomEntity(
    noteRoomId = this.roomId,
    nickName = this.nickname
)