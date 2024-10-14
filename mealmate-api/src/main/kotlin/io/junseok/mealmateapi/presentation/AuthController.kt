
package io.junseok.mealmateapi.presentation

import io.junseok.mealmateapi.auth.LoginAuth
import io.junseok.mealmateapi.auth.dto.LoginDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin
class AuthController(
    private val loginAuthService: LoginAuth
) {
    @PostMapping("/login")
    fun authorize(@RequestBody loginDto: LoginDto) =
        loginAuthService.login(loginDto).also {
            ResponseEntity.ok(it)
        }
}
