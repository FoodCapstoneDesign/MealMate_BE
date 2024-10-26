package io.junseok.mealmatestorage.persistence.noteroommember

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import io.junseok.mealmatestorage.persistence.noteroom.NoteRoomEntity
import javax.persistence.*

@Entity
@Table(name = "note_members")
class NoteRoomMemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_members_id")
    var noteMembersId: Long? =null,

    @Column(name= "room_name")
    var roomName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "principal_id")
    val principalEntity: MemberEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    val noteRoomEntity: NoteRoomEntity
) {
}