package com.artist.server.factory

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.*

data class SurveyJwtPayload(
    val hospitalId: Long,
    val patientId: Long,
    val surveyIdList: List<Long>,
    var expireTime: Long? = null,
)

@Component
class JwtTokenFactory {

    companion object {

        const val JWT_EXPIRE = 86_400_000 // 24시간 24 * 60 * 60 * 1000

        const val HOSPITAL_ID_KEY = "hospitalId"
        const val SURVEY_ID_LIST_KEY = "surveyIdList"
        const val EXPIRE_TIME_KEY = "expireTime"
    }

    @Value("\${jhipster.security.authentication.jwt.secret}")
    var secret: String? = null

    fun generateSurveyJwt(payload: SurveyJwtPayload): String {
        val now = Date()

        val expireTime = payload.expireTime
        if (null == expireTime) {
            val expire = Date(now.time + JWT_EXPIRE)
            payload.expireTime = expire.time
        }

        val keyBytes = secret?.toByteArray(StandardCharsets.UTF_8)

        return Jwts
            .builder()
            .setSubject(payload.patientId.toString())
            .claim(HOSPITAL_ID_KEY, payload.hospitalId)
            .claim(SURVEY_ID_LIST_KEY, payload.surveyIdList)
            .claim(EXPIRE_TIME_KEY, payload.expireTime)
            .setIssuedAt(Date())
            .setExpiration(Date(payload.expireTime!!))
            .signWith(Keys.hmacShaKeyFor(keyBytes), SignatureAlgorithm.HS256)
            .compact()
    }

    fun parserSurveyJwt(jwt: String): SurveyJwtPayload {
        val keyBytes = secret?.toByteArray(StandardCharsets.UTF_8)

        val parser = Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(keyBytes))
            .build()

        val claims = parser.parseClaimsJws(jwt).body
        val userId = claims.subject.toLong()
        val hospitalId = claims[HOSPITAL_ID_KEY].toString().toLong()
        val surveyIdList = claims[SURVEY_ID_LIST_KEY] as List<Int>
        val expireTime = claims.expiration.time.toString().toLong()
        return SurveyJwtPayload(hospitalId, userId, surveyIdList.map { it.toLong() }, expireTime)
    }
}
