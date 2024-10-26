package io.junseok.mealmatestorage.persistence.noteroommember

import io.junseok.domain.noteroommember.NoteRoomMember
import io.junseok.domain.noteroommember.NoteRoomMemberInfo
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.noteroom.toEntity
import java.time.LocalDateTime

fun NoteRoomMemberEntity.toNoteRoomInfo()=NoteRoomMemberInfo(
    roomName = this.roomName,
    message = "1212",
    sendDt = LocalDateTime.now()
)
fun NoteRoomMember.toEntity() = NoteRoomMemberEntity(
    principalEntity = this.principal.toEntity(),
    noteRoomEntity = this.noteRoom.toEntity(),
    roomName = this.opponent.nickname
)