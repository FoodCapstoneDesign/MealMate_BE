package io.junseok.mealmatestorage.persistence.noteroommember

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRoomMemberJpaRepository : JpaRepository<NoteRoomMemberEntity,Long> {
    fun deleteByPrincipalEntity(memberEntity: MemberEntity)

    fun findAllByPrincipalEntity(memberEntity: MemberEntity):List<NoteRoomMemberEntity>
}