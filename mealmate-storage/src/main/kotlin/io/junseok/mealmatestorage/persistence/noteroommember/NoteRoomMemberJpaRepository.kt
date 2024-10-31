package io.junseok.mealmatestorage.persistence.noteroommember

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.Optional

interface NoteRoomMemberJpaRepository : JpaRepository<NoteRoomMemberEntity, Long> {
    fun deleteByPrincipalEntity(memberEntity: MemberEntity)

    fun findAllByPrincipalEntity(memberEntity: MemberEntity): List<NoteRoomMemberEntity>

    @Query(
        value = "SELECT n.* FROM note_members n " +
                "WHERE (n.principal_id = :owned AND n.room_name = :opponentNickname) " +
                "OR (n.principal_id = :opponent AND n.room_name = :ownedNickname) " +
                "LIMIT 1",
        nativeQuery = true
    )
    fun findByPrincipalEntityAndRoomName(
        @Param(value = "owned") owned: MemberEntity,
        @Param(value = "opponentNickname") opponentName: String,
        @Param(value = "opponent") opponent: MemberEntity,
        @Param(value = "ownedNickname") ownedNickname: String
    ): Optional<NoteRoomMemberEntity>
}