package io.junseok.mealmatestorage.persistence.noteroom

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRoomJpaRepository : JpaRepository<NoteRoomEntity,Long> {
    fun deleteByPrincipalEntity(memberEntity: MemberEntity)
}