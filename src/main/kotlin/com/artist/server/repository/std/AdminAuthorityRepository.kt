package com.artist.server.repository.std

import com.artist.server.domain.core.StdAdminAuthority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the StdAdminAuthority entity.
 */
@Suppress("unused")
@Repository
interface AdminAuthorityRepository :
    JpaRepository<StdAdminAuthority, Long>,
    JpaSpecificationExecutor<StdAdminAuthority> {

    fun findAllByAdminIdAndIsDeletedIsFalse(adminId: Long): List<StdAdminAuthority>
}
