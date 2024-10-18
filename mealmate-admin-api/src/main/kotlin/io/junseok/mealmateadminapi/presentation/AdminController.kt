package io.junseok.mealmateadminapi.presentation

import io.junseok.mealmateadminapi.auth.service.AdminAuthService
import io.junseok.mealmateadminapi.auth.dto.LoginDto
import io.junseok.mealmateadminapi.domain.AdminService
import io.junseok.mealmateadminapi.presentation.dto.request.AdminRequest
import io.junseok.mealmateadminapi.presentation.dto.request.AdminRequest.Companion.toDomain
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
class AdminController(
    private val adminService: AdminService,
    private val loginAuthService: AdminAuthService

) {
    @PostMapping("/signup")
    fun adminSignUp(@RequestBody adminRequest: AdminRequest): ResponseEntity<Long> =
        ResponseEntity.ok(adminService.createAdmin(adminRequest.toDomain()))


    @DeleteMapping
    fun adminDelete(principal: Principal): ResponseEntity<Unit>{
        adminService.deleteAdmin(principal.name)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/login")
    fun authorize(@RequestBody loginDto: LoginDto) =
        loginAuthService.login(loginDto).also {
            ResponseEntity.ok(it)
        }
}