package io.junseok.mealmatestorage.persistence.note

import io.junseok.domain.member.Member
import io.junseok.domain.note.Note
import io.junseok.domain.note.NoteInfo
import io.junseok.domain.note.NoteRepository
import io.junseok.domain.noteroom.NoteRoom
import io.junseok.domain.noteroommember.NoteRoomMemberInfo
import io.junseok.mealmatestorage.persistence.noteroom.toEntity
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class NoteEntityRepository(
    private val noteJpaRepository: NoteJpaRepository,
) : NoteRepository{
    @Transactional
    override fun save(note: Note): Long? =
        noteJpaRepository.save(note.toEntity()).noteId

    @Transactional(readOnly = true)
    override fun findByNoteRoom(noteRoom: NoteRoom, opponentId: Long): List<NoteInfo> =
        noteJpaRepository.findAllByNoteRoom(noteRoom.toEntity())
            .map { it.toDomain(opponentId) }

    @Transactional(readOnly = true)
    override fun findAllByNoteRoomForLastNote(noteRoom: NoteRoom): NoteRoomMemberInfo {
        return noteJpaRepository.findTopByNoteRoomOrderByCreateDtDesc(noteRoom.toEntity())
            .toNoteRoomMember(noteRoom)
    }

}