package io.junseok.mealmateapi.presentation.membercategory.dto.request

import io.junseok.domain.membercategory.CategoryRegister
import io.junseok.domain.membercategory.CategoryRegisters

data class MemberCategoryRequest(val categoryName: String){
    companion object{
        fun List<MemberCategoryRequest>.toCategoryRegisters() = CategoryRegisters(
            this.map {
                CategoryRegister(
                    categoryName = it.categoryName
                )
            }
        )
    }
}
