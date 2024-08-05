package com.artist.server.repository.core

import com.artist.server.domain.core.StdCommonGroupCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the StdCommonGroupCode entity.
 */
@Suppress("unused")
@Repository
interface StdCommonGroupCodeRepository : JpaRepository<StdCommonGroupCode, Long>, JpaSpecificationExecutor<StdCommonGroupCode>
