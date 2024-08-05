package com.artist.server.repository.core

import com.artist.server.domain.core.StdContents
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 * Spring Data JPA repository for the StdContents entity.
 */
@Suppress("unused")
@Repository
interface StdContentsRepository : JpaRepository<StdContents, Long>, JpaSpecificationExecutor<StdContents>
