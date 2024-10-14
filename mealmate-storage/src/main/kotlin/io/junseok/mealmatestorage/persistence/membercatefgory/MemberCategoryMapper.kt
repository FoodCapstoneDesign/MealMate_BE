package io.junseok.mealmatestorage.persistence.membercatefgory

import io.junseok.domain.member.Member
import io.junseok.domain.membercategory.CategoryRegister
import io.junseok.domain.membercategory.CategoryRegisters
import io.junseok.mealmatestorage.persistence.member.toEntity

fun CategoryRegisters.toEntity(member: Member): MutableList<MemberCategoryEntity> {
    val memberCategories: MutableList<MemberCategoryEntity> = ArrayList()
    this.categoryRegisters.map {
        MemberCategoryEntity(
            categoryName = it.categoryName,
            memberEntity = member.toEntity()
        ).also { memberCategories.add(it) }
    }
    return memberCategories
}

fun List<MemberCategoryEntity>.toDomain()=CategoryRegisters(
    this.map {
        CategoryRegister(
            categoryName = it.categoryName
        )
    }
)