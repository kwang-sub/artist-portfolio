package com.artist.server.repository.std

import com.artist.server.domain.core.StdAuthority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.Optional

/**
 * Spring Data JPA repository for the StdAuthority entity.
 */
@Suppress("unused")
@Repository
interface AuthorityRepository : JpaRepository<StdAuthority, Long>, JpaSpecificationExecutor<StdAuthority> {

    fun findByAuthorityCodeAndIsDeletedIsFalse(authCode: String?): Optional<StdAuthority>
}
