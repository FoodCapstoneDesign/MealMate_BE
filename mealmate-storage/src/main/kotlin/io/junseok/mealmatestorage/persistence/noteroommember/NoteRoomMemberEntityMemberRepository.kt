package io.junseok.mealmatestorage.persistence.noteroommember

import io.junseok.domain.member.Member
import io.junseok.domain.noteroommember.NoteRoomMember
import io.junseok.domain.noteroommember.NoteRoomMemberInfo
import io.junseok.domain.noteroommember.NoteRoomMemberRepository
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.note.toEntity
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class NoteRoomMemberEntityMemberRepository(
    private val noteRoomMemberJpaRepository: NoteRoomMemberJpaRepository
): NoteRoomMemberRepository {
    @Transactional
    override fun save(noteRoomMember: NoteRoomMember): Long =
        noteRoomMemberJpaRepository.save(noteRoomMember.toEntity()).noteMembersId!!

    @Transactional
    override fun delete(member: Member) =
        noteRoomMemberJpaRepository.deleteByPrincipalEntity(member.toEntity())

    @Transactional(readOnly = true)
    override fun findAllByMember(member: Member): List<NoteRoomMemberInfo> =
        noteRoomMemberJpaRepository.findAllByPrincipalEntity(member.toEntity())
            .map { it.toNoteRoomInfo() }

}