package io.junseok.mealmateadminapi.auth.dto

data class TokenDto(
    val token: String,
    val authority: String
)
