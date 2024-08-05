package com.artist.server.repository.std

import com.artist.server.domain.core.StdCommonCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.Optional

/**
 * Spring Data JPA repository for the StdCommonCode entity.
 */
@Suppress("unused")
@Repository
interface CommonCodeRepository : JpaRepository<StdCommonCode, Long>, JpaSpecificationExecutor<StdCommonCode> {
    fun findAllByCommonGroupCodeIdEqualsAndIsDeletedIsFalse(id: Long): Optional<MutableList<StdCommonCode>>

    fun getCommonCodeListByGroupCodeId(id: Long) = findAllByCommonGroupCodeIdEqualsAndIsDeletedIsFalse(id)
}
