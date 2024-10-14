package io.junseok.domain.member

interface MemberRepository {
    fun findByEmail(email: String): Member
    fun save(memberSignUp: MemberSignUp): Long
    fun findById(memberId: Long): Member
    fun findOneWithAuthoritiesByEmail(email: String): Member?
    fun existsByEmail(email: String): Boolean
    fun delete(email: String)
    fun update(member: Member)
}