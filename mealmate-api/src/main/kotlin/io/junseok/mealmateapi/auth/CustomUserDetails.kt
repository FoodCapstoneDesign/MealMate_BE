package io.junseok.mealmateapi.auth

import io.junseok.domain.auth.CustomUserDetailsService
import io.junseok.domain.member.Member
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component("userDetailsService")
class CustomUserDetails(
    private val customUserDetailsService: CustomUserDetailsService
) : UserDetailsService{
    override fun loadUserByUsername(email: String): UserDetails {
        val member = customUserDetailsService.findAuthorityMember(email)
        return createAdmin(email,member!!)
    }

    fun createAdmin(email: String, member: Member): User{
        if(!member.activated){
            throw RuntimeException(email+"가 활성화되어 있지 않습니다")
        }

        val grantedAuthorities = SimpleGrantedAuthority(member.authority)
        return User(member.email, member.password, setOf(grantedAuthorities))
    }
}
