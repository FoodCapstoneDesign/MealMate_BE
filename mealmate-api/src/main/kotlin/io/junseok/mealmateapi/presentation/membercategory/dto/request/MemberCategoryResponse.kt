package io.junseok.mealmateapi.presentation.membercategory.dto.request

import io.junseok.domain.membercategory.CategoryRegisters

data class MemberCategoryResponse(val categoryName: String) {
    companion object {
        fun CategoryRegisters.toResponse(): List<MemberCategoryResponse> {
            return this.categoryRegisters.map {
                MemberCategoryResponse(
                    categoryName = it.categoryName
                )
            }
        }
    }
}
