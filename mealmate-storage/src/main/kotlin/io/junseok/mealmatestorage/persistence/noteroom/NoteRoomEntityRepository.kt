package io.junseok.mealmatestorage.persistence.noteroom

import io.junseok.domain.member.Member
import io.junseok.domain.noteroom.NoteRoom
import io.junseok.domain.noteroom.NoteRoomRepository
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.note.toEntity
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class NoteRoomEntityRepository(
    private val noteRoomJpaRepository: NoteRoomJpaRepository
): NoteRoomRepository {
    @Transactional
    override fun save(noteRoom: NoteRoom): Long =
        noteRoomJpaRepository.save(noteRoom.toEntity()).noteMembersId!!

    @Transactional
    override fun delete(member: Member) =
        noteRoomJpaRepository.deleteByPrincipalEntity(member.toEntity())
}