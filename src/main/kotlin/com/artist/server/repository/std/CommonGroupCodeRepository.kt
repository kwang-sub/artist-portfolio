package com.artist.server.repository.std

import com.artist.server.domain.core.StdCommonGroupCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Spring Data JPA repository for the StdCommonGroupCode entity.
 */
@Suppress("unused")
@Repository
interface CommonGroupCodeRepository :
    JpaRepository<StdCommonGroupCode, Long>,
    JpaSpecificationExecutor<StdCommonGroupCode> {

    fun findByIdAndIsDeletedIsFalse(id: Long): Optional<StdCommonGroupCode>
}
