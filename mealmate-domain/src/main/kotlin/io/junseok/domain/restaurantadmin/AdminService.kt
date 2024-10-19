package io.junseok.domain.restaurantadmin

import org.springframework.stereotype.Service

@Service
class AdminService(
    private val adminCreator: AdminCreator,
    private val adminRemover: AdminRemover
) {
    fun createAdmin(admin: Admin): Long = adminCreator.save(admin)

    fun deleteAdmin(email: String) = adminRemover.delete(email)
}