package com.artist.server.service.core.criteria

import org.springdoc.api.annotations.ParameterObject
import tech.jhipster.service.Criteria
import tech.jhipster.service.filter.*
import java.io.Serializable

/**
 * Criteria class for the [com.artist.server.domain.StdAuthority] entity. This class is used in
 * [com.artist.server.web.rest.StdAuthorityResource] to receive all the possible filtering options from the
 * Http GET request parameters.
 * For example the following could be a valid request:
 * ```/std-authorities?id.greaterThan=5&attr1.contains=something&attr2.specified=false```
 * As Spring is unable to properly convert the types, unless specific [Filter] class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdAuthorityCriteria(
    var id: LongFilter? = null,
    var authorityCode: StringFilter? = null,
    var authorityName: StringFilter? = null,
    var authorityDesc: StringFilter? = null,
    var isActivated: BooleanFilter? = BooleanFilter(),
    var isDeleted: BooleanFilter? = BooleanFilter(),
    var createdBy: StringFilter? = null,
    var createdDate: ZonedDateTimeFilter? = null,
    var lastModifiedBy: StringFilter? = null,
    var lastModifiedDate: ZonedDateTimeFilter? = null,
    var stdAdminAuthorityId: LongFilter? = null,
    var stdMenuAuthorityId: LongFilter? = null,
    var distinct: Boolean? = null
) : Serializable, Criteria {

    constructor(other: StdAuthorityCriteria) :
        this(
            other.id?.copy(),
            other.authorityCode?.copy(),
            other.authorityName?.copy(),
            other.authorityDesc?.copy(),
            other.isActivated?.copy(),
            other.isDeleted?.copy(),
            other.createdBy?.copy(),
            other.createdDate?.copy(),
            other.lastModifiedBy?.copy(),
            other.lastModifiedDate?.copy(),
            other.stdAdminAuthorityId?.copy(),
            other.stdMenuAuthorityId?.copy(),
            other.distinct
        )

    override fun copy() = StdAuthorityCriteria(this)

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
