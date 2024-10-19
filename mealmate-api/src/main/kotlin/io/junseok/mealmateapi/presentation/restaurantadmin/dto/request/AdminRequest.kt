package io.junseok.mealmateapi.presentation.restaurantadmin.dto.request

import io.junseok.domain.restaurantadmin.Admin
import io.junseok.toEncrypt

data class AdminRequest(
    val email: String,
    val restaurantName: String,
    val password: String
){
    companion object{
        fun AdminRequest.toDomain()= Admin(
            email = this.email,
            restaurantName= this.restaurantName,
            password = this.password.toEncrypt(),
            activated = true,
            authority = "ROLE_ADMIN"
        )
    }
}
