package io.junseok.mealmatestorage.persistence.member

import io.junseok.domain.member.Member
import io.junseok.domain.member.MemberRepository
import io.junseok.domain.member.MemberSignUp
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class MemberEntityRepository(
    private val memberJpaRepository: MemberJpaRepository,
) : MemberRepository {
    @Transactional(readOnly = true)
    override fun findByEmail(email: String) =
        memberJpaRepository.findByEmail(email)?.toDomain()
            ?: throw MealMateException(ErrorCode.NOT_EXIST_MEMBER)

    @Transactional
    override fun save(memberSignUp: MemberSignUp): Long {
        return memberJpaRepository.save(memberSignUp.toEntity()).memberId!!
    }

    @Transactional(readOnly = true)
    override fun findById(memberId: Long): Member {
        val memberEntity = memberJpaRepository.findByIdOrNull(memberId)
            ?: throw MealMateException(ErrorCode.NOT_EXIST_MEMBER)
        return memberEntity.toDomain()
    }

    @Transactional(readOnly = true)
    override fun findOneWithAuthoritiesByEmail(email: String): Member? {
        val memberEntity = memberJpaRepository.findOneWithAuthoritiesByEmail(email)
            ?: throw MealMateException(ErrorCode.NOT_EXIST_MEMBER)
        return memberEntity.toDomain()
    }

    @Transactional(readOnly = true)
    override fun existsByEmail(email: String): Boolean = memberJpaRepository.existsByEmail(email)

    @Transactional
    override fun delete(email: String) {
        val memberEntity = memberJpaRepository.findByEmail(email)
            ?: throw MealMateException(ErrorCode.NOT_EXIST_MEMBER)
        memberJpaRepository.delete(memberEntity)
    }

    @Transactional
    override fun update(member: Member) = memberJpaRepository.findByEmail(member.email)
            ?.updatePassword(member.password)
            ?: throw MealMateException(ErrorCode.NOT_EXIST_MEMBER)

    @Transactional(readOnly = true)
    override fun findMemberByNickname(nickname: String): Long =
        memberJpaRepository.findByNickname(nickname).memberId!!
}