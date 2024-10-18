package io.junseok.mealmateadminapi.presentation.dto.request

import io.junseok.mealmateadminapi.domain.Admin
import io.junseok.toEncrypt

data class AdminRequest(
    val email: String,
    val restaurantName: String,
    val password: String
){
    companion object{
        fun AdminRequest.toDomain()=Admin(
            email = this.email,
            restaurantName= this.restaurantName,
            password = this.password.toEncrypt(),
            activated = true,
            authority = "ROLE_ADMIN"
        )
    }
}
