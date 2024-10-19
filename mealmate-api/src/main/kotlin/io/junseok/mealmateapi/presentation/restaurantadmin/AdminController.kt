package io.junseok.mealmateapi.presentation.restaurantadmin

import io.junseok.domain.restaurantadmin.AdminService
import io.junseok.mealmateapi.auth.LoginAdminAuth
import io.junseok.mealmateapi.auth.dto.LoginDto
import io.junseok.mealmateapi.presentation.restaurantadmin.dto.request.AdminRequest
import io.junseok.mealmateapi.presentation.restaurantadmin.dto.request.AdminRequest.Companion.toDomain
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
class AdminController(
    private val adminService: AdminService,
    private val loginAdminAuth: LoginAdminAuth

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
        loginAdminAuth.login(loginDto).also {
            ResponseEntity.ok(it)
        }
}