package io.junseok.mealmatestorage.persistence.membercatefgory

import io.junseok.domain.membercategory.CategoryRegisters
import io.junseok.domain.membercategory.MemberCategoryRepository
import io.junseok.mealmatestorage.persistence.member.MemberEntityRepository
import io.junseok.mealmatestorage.persistence.member.toEntity
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class MemberCategoryEntityRepository(
    private val memberCategoryJpaRepository: MemberCategoryJpaRepository,
    private val memberEntityRepository: MemberEntityRepository
) : MemberCategoryRepository {
    @Transactional
    override fun save(categoryRegisters: CategoryRegisters, memberId: Long) {
        memberCategoryJpaRepository.saveAll(categoryRegisters.toEntity(memberEntityRepository.findById(memberId)))
    }

    @Transactional(readOnly = true)
    override fun findAllByMember(email: String): CategoryRegisters {
        val member = memberEntityRepository.findByEmail(email).toEntity()
        return memberCategoryJpaRepository.findAllByMemberEntity(member).toDomain()
    }

    @Transactional
    override fun deleteAllByMember(memberId: Long) {
        val member = memberEntityRepository.findById(memberId).toEntity()
        memberCategoryJpaRepository.deleteAllByMemberEntity(member)
    }
}