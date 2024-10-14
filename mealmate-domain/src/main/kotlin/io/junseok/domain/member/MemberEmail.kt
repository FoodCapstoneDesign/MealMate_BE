package io.junseok.domain.member

import io.junseok.domain.member.serviceimpl.MemberValidator

data class MemberEmail(val email: String){
    init {
        MemberValidator.valid(email)
    }
}
