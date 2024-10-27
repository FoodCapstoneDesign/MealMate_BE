package io.junseok.mealmatestorage.persistence.noteroommember

import io.junseok.domain.noteroom.NoteRoom
import io.junseok.domain.noteroommember.NoteRoomMember
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.noteroom.toEntity

fun NoteRoomMemberEntity.toNoteRoom()= NoteRoom(
    roomId = this.noteRoomEntity.noteRoomId!!,
    creator = this.roomName
)
fun NoteRoomMember.toEntity() = NoteRoomMemberEntity(
    principalEntity = this.principal.toEntity(),
    noteRoomEntity = this.noteRoom.toEntity(),
    roomName = this.opponent.nickname
)