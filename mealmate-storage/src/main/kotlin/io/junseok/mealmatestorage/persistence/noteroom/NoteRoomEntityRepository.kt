package io.junseok.mealmatestorage.persistence.noteroom

import io.junseok.domain.noteroom.NoteRoom
import io.junseok.domain.noteroom.NoteRoomRepository
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class NoteRoomEntityRepository(
    private val noteRoomJpaRepository: NoteRoomJpaRepository
) : NoteRoomRepository{
    @Transactional
    override fun save(nickname: String): NoteRoom =
        noteRoomJpaRepository.save(nickname.toEntityByNickname()).toDomain()

    @Transactional(readOnly = true)
    override fun findById(noteRoomId: Long): NoteRoom =
        noteRoomJpaRepository.findByIdOrNull(noteRoomId)?.toDomain()
            ?: throw MealMateException(ErrorCode.NOT_EXIST_RESTAURANT)


}