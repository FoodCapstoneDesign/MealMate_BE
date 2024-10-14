package io.junseok.mealmatestorage.persistence.membercatefgory

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.Member

interface MemberCategoryJpaRepository : JpaRepository<MemberCategoryEntity,Long>  {
    fun findAllByMemberEntity(memberEntity: MemberEntity): List<MemberCategoryEntity>
    fun deleteAllByMemberEntity(memberEntity: MemberEntity)
}