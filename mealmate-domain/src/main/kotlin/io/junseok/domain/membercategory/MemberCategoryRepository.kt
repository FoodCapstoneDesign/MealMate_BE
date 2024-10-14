package io.junseok.domain.membercategory


interface MemberCategoryRepository {
    fun save(categoryRegisters: CategoryRegisters,memberId: Long)
    fun findAllByMember(email: String): CategoryRegisters
    fun deleteAllByMember(memberId: Long)
}