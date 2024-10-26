package io.junseok.mealmatestorage.persistence.noteroom

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import javax.persistence.*

@Entity
@Table(name = "note_members")
class NoteRoomEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_members_id")
    var noteMembersId: Long? =null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "principal_id")
    val principalEntity: MemberEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opponent_id")
    val opponentEntity: MemberEntity
) {
}