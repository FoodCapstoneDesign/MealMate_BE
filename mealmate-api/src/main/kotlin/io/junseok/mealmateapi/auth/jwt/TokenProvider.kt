package io.junseok.mealmateapi.auth.jwt

import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SecurityException
import io.junseok.mealmateapi.auth.jwt.SecurityMessage.Companion.EXPIRED_JWT
import io.junseok.mealmateapi.auth.jwt.SecurityMessage.Companion.MALFORMED_JWT
import io.junseok.mealmateapi.auth.jwt.SecurityMessage.Companion.UNSUPPORT_JWT
import io.junseok.mealmateapi.auth.jwt.SecurityMessage.Companion.WRONG_JWT
import mu.KotlinLogging
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import java.util.stream.Collectors

@Component
class TokenProvider(
    @Value("\${jwt.secret}") private val secret: String,
    @Value("\${jwt.token-validity-in-seconds}")private val tokenValidityInSeconds: Long
) :
    InitializingBean {
    private val tokenValidityInMilliseconds = tokenValidityInSeconds * 1000
    private var key: Key? = null
    val log = KotlinLogging.logger {}
    @Throws(Exception::class)
    override fun afterPropertiesSet() {
        val keyBytes = Decoders.BASE64.decode(secret)
        this.key = Keys.hmacShaKeyFor(keyBytes)
    }

    fun createToken(email: String, authority: String): String {
        val now = Date().time
        val validity = Date(now + this.tokenValidityInMilliseconds)

        return Jwts.builder()
            .setSubject(email)
            .setIssuer("MealMate")
            .claim(AUTHORITIES_KEY, authority)
            .signWith(key, SignatureAlgorithm.HS512)
            .setExpiration(validity)
            .compact()
    }

    fun getAuthentication(token: String?): Authentication {
        val claims = Jwts
            .parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body

        val authorities: Collection<GrantedAuthority> =
            Arrays.stream(
                claims[AUTHORITIES_KEY].toString().split(",".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray())
                .map { role: String? ->
                    SimpleGrantedAuthority(
                        role
                    )
                }
                .collect(Collectors.toList())

        return UsernamePasswordAuthenticationToken(claims.subject, token, authorities)
    }

    fun validateToken(token: String?): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            return true
        } catch (e: SecurityException) {
            log.error(MALFORMED_JWT)
        } catch (e: MalformedJwtException) {
            log.error(MALFORMED_JWT)
        } catch (e: ExpiredJwtException) {
            log.error(EXPIRED_JWT)
        } catch (e: UnsupportedJwtException) {
            log.error(UNSUPPORT_JWT)
        } catch (e: IllegalArgumentException) {
            log.error(WRONG_JWT)
        }
        return false
    }

    companion object {
        private const val AUTHORITIES_KEY = "auth"
    }
}