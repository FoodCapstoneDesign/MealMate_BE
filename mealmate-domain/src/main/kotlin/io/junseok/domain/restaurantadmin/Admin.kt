package io.junseok.domain.restaurantadmin

data class Admin(
    val email: String,
    val restaurantName: String,
    val password: String,
    val activated: Boolean,
    val authority: String
)
