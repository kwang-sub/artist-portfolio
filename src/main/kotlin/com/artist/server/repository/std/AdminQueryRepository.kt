package com.artist.server.repository.std

import com.artist.server.domain.core.QStdAdmin
import com.artist.server.domain.core.QStdAdminAuthority
import com.artist.server.domain.core.QStdAuthority
import com.artist.server.domain.core.StdAdmin
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the {@link StdAdmin} entity.
 */
@Repository
class AdminQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {

    private val qStdAdmin = QStdAdmin("stdAdmin")
    private val qStdAdminAuth = QStdAdminAuthority("stdAdminAuthority")
    private val qAuth = QStdAuthority("stdAuthority")

    /**
     * 어드민 전체 조회
     */
    fun findByAllUsers(): MutableList<StdAdmin> {
        return jpaQueryFactory
            .selectFrom(qStdAdmin)
            .innerJoin(qStdAdmin.stdAuthorities, qAuth)
            .fetch()
    }

    /**
     * 어드민 상세조회
     * @param loginId 로그인ID
     */
    fun findByUserLoginId(loginId: String): StdAdmin? {
        return jpaQueryFactory
            .selectFrom(qStdAdmin)
            .innerJoin(qStdAdmin.stdAuthorities, qAuth)
            .where(
                qStdAdmin.adminLoginId.eq(loginId)
            )
            .fetchOne()
    }

    /**
     * 어드민 상세조회
     * @param id db id
     */
    fun findById(id: Long): StdAdmin? {
        return jpaQueryFactory
            .selectFrom(qStdAdmin)
            .innerJoin(qStdAdmin.stdAuthorities, qAuth)
            .where(
                qStdAdmin.id.eq(id)
            )
            .fetchOne()
    }

    /**
     * 권한코드로 어드민 목록 조회
     * @param authCode 권한코드명 (eg: DOCTOR)
     */
    fun findByUserWithAuthCode(authCode: String): MutableList<StdAdmin> {
        return jpaQueryFactory
            .selectFrom(qStdAdmin)
            .innerJoin(qStdAdmin.stdAuthorities, qAuth)
            .where(
                qAuth.authorityCode.eq(authCode)
            )
            .fetch()
    }
}
