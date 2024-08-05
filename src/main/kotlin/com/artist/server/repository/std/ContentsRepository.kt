package com.artist.server.repository.std

import com.artist.server.domain.core.StdContents
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Spring Data JPA repository for the StdContents entity.
 */
@Suppress("unused")
@Repository
interface ContentsRepository : JpaRepository<StdContents, Long>, JpaSpecificationExecutor<StdContents> {
    fun findByIdAndIsDeletedIsFalse(id: Long): Optional<StdContents>
}
