package com.artist.server.repository.std

import com.artist.server.domain.core.StdAdmin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Spring Data JPA repository for the StdAdmin entity.
 */
@Suppress("unused")
@Repository
interface AdminRepository : JpaRepository<StdAdmin, Long>, JpaSpecificationExecutor<StdAdmin> {

    fun findByAdminUserNameEqualsAndIsDeletedFalse(userName: String): Optional<StdAdmin>
}
