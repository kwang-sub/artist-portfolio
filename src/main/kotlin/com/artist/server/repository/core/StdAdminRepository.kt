package com.artist.server.repository.core

import com.artist.server.domain.core.StdAdmin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the StdAdmin entity.
 */
@Suppress("unused")
@Repository
interface StdAdminRepository : JpaRepository<StdAdmin, Long>, JpaSpecificationExecutor<StdAdmin> {

    fun findByIdAndIsDeletedFalse(id: Long): StdAdmin?
    fun findByAdminLoginIdEqualsAndIsDeletedFalse(loginId: String): StdAdmin?

    fun existsByAdminLoginIdAndIsDeletedFalse(loginId: String): Boolean
    fun existsByAdminLoginIdAndIdNotAndIsDeletedFalse(loginId: String, id: Long): Boolean

    companion object {

        const val USERS_BY_LOGIN_CACHE: String = "usersByLogin"
        const val USERS_BY_EMAIL_CACHE: String = "usersByEmail"
    }
}
