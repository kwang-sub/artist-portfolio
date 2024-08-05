package com.artist.server.repository.core

import com.artist.server.domain.core.StdMessage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.Optional

/**
 * Spring Data JPA repository for the StdMessage entity.
 */
@Suppress("unused")
@Repository
interface StdMessageRepository : JpaRepository<StdMessage, Long>, JpaSpecificationExecutor<StdMessage> {

    fun findTop1ByMessageCodeAndIsActivatedTrueAndIsDeletedFalse(messageCode: String): Optional<StdMessage>
}
