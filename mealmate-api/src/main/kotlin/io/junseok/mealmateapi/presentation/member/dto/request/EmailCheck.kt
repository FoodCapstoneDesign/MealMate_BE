package io.junseok.mealmateapi.presentation.member.dto.request

import io.junseok.domain.member.MemberEmail

data class EmailCheck(val email: String){
    companion object{
        fun EmailCheck.toMemberEmail()= MemberEmail(email = email)
    }
}


