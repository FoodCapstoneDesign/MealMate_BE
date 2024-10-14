package io.junseok

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

object EncryptionContext {
    val encoder: PasswordEncoder = BCryptPasswordEncoder()
}

fun String.toEncrypt(): String {
    return EncryptionContext.encoder.encode(this)
}
