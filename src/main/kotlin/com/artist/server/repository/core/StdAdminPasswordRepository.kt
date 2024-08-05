package com.artist.server.repository.core

import com.artist.server.domain.core.StdAdminPassword
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the StdAdminPassword entity.
 */
@Suppress("unused")
@Repository
interface StdAdminPasswordRepository : JpaRepository<StdAdminPassword, Long>, JpaSpecificationExecutor<StdAdminPassword>
