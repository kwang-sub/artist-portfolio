package com.artist.server.repository.core

import com.artist.server.domain.core.StdAuthority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the StdAuthority entity.
 */
@Suppress("unused")
@Repository
interface StdAuthorityRepository : JpaRepository<StdAuthority, Long>, JpaSpecificationExecutor<StdAuthority>
