package com.artist.server.repository.core

import com.artist.server.domain.core.StdCommonCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the StdCommonCode entity.
 */
@Suppress("unused")
@Repository
interface StdCommonCodeRepository : JpaRepository<StdCommonCode, Long>, JpaSpecificationExecutor<StdCommonCode>
