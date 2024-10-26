package io.junseok.mealmatestorage.persistence.note

import io.junseok.mealmatestorage.persistence.base.BaseTimeEntity
import io.junseok.mealmatestorage.persistence.member.MemberEntity
import io.junseok.mealmatestorage.persistence.noteroom.NoteRoomEntity
import io.junseok.mealmatestorage.persistence.noteroommember.NoteRoomMemberEntity
import javax.persistence.*

@Entity
@Table(name = "note")
class NoteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    var noteId: Long ?= null,

    @Column(name = "note_message")
    var noteMessage: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    val senderMember: MemberEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    val receiverMember: MemberEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_room")
    val noteRoom: NoteRoomEntity
) :BaseTimeEntity() {

}
