package io.junseok.mealmateadminapi.auth.jwt

import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component("adminTokenProvider")
class AdminTokenProvider(
    @Value("\${jwt.secret}") private val secret: String,
    @Value("\${jwt.token-validity-in-seconds}")private val tokenValidityInSeconds: Long
) :
    InitializingBean {
    private val tokenValidityInMilliseconds = tokenValidityInSeconds * 1000
    private var key: Key? = null
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

    companion object {
        private const val AUTHORITIES_KEY = "auth"
    }
}