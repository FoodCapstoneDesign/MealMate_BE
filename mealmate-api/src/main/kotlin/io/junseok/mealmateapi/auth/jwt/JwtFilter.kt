package io.junseok.mealmateapi.auth.jwt

import io.junseok.mealmateapi.auth.jwt.SecurityMessage.Companion.SUCCESS_AUTHENTICATION
import mu.KotlinLogging
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.util.StringUtils
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtFilter(
    private val tokenProvider: TokenProvider
) : GenericFilterBean() {
    val log = KotlinLogging.logger {}
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpServletRequest = request as HttpServletRequest
        val jwt = resolveToken(httpServletRequest)
        if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
            val authentication = tokenProvider.getAuthentication(jwt)
            SecurityContextHolder.getContext().authentication = authentication
            log.info(SUCCESS_AUTHENTICATION)
        }
        chain.doFilter(request, response)
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(AUTHORIZATION_HEADER)
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7)
        }
        return null
    }

    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
    }
}