package org.example.spartatodolist.infra.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.Instant
import java.util.*


@Component
class JwtPlugin (
    @Value("\${auth.jwt.issuer}") private val issuer:String,
    @Value("\${auth.jwt.secret}") private val secret:String,
    @Value("\${auth.jwt.accessTokenExpirationHour}") private val accessTokenExpirationHour:Long,
){

    fun validateToken(jwt: String): Result<Jws<Claims>>{ // Result는 try catch 대신에 사용하는것, 코틀린에서 우아하게 exception을 처리할때 Result 객체를 반환함. 실제로 validateToken()을 사용하는 쪽에서 exception을 핸들링할수 있게끔 한다

        return kotlin.runCatching {
            val key = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))

            Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt)
        }
    }

    fun generateAccessToken(subject: String,email:String, role:String): String{

        return generateToken(subject, email, role,Duration.ofHours(accessTokenExpirationHour))
    }

    private fun generateToken(subject: String,email:String,role:String, expirationPeriod: Duration): String{

        val claims: Claims = Jwts.claims()
            .add(mapOf("role" to role, "email" to email))
            .build()

        val key = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))
        val now= Instant.now()

        return Jwts.builder()
            .subject(subject)
            .issuer(issuer)
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plus(expirationPeriod)))
            .claims(claims)
            .signWith(key)
            .compact()
    }
}