package io.junseok.mealmatestorage.persistence.note

import io.junseok.domain.note.Note
import io.junseok.domain.note.NoteInfo
import io.junseok.domain.noteroommember.NoteRoomMember
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.noteroom.toEntity
import io.junseok.mealmatestorage.persistence.noteroommember.NoteRoomMemberEntity



fun Note.toEntity()=NoteEntity(
    noteMessage = this.message,
    senderMember = this.sender!!.toEntity(),
    receiverMember = this.receiver!!.toEntity(),
    noteRoom = this.noteRoom!!.toEntity()
)

fun NoteEntity.toDomain()=NoteInfo(
    message = this.noteMessage,
    sendDt = this.createDt!!,
    email = this.senderMember.email
)