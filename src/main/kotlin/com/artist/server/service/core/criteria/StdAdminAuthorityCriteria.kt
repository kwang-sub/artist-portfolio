package com.artist.server.service.core.criteria

import org.springdoc.api.annotations.ParameterObject
import tech.jhipster.service.Criteria
import tech.jhipster.service.filter.*
import java.io.Serializable

/**
 * Criteria class for the [com.artist.server.domain.StdAdminAuthority] entity. This class is used in
 * [com.artist.server.web.rest.StdAdminAuthorityResource] to receive all the possible filtering options from the
 * Http GET request parameters.
 * For example the following could be a valid request:
 * ```/std-admin-authorities?id.greaterThan=5&attr1.contains=something&attr2.specified=false```
 * As Spring is unable to properly convert the types, unless specific [Filter] class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdAdminAuthorityCriteria(
    var id: LongFilter? = null,
    var isDeleted: BooleanFilter? = BooleanFilter(),
    var createdBy: StringFilter? = null,
    var createdDate: ZonedDateTimeFilter? = null,
    var lastModifiedBy: StringFilter? = null,
    var lastModifiedDate: ZonedDateTimeFilter? = null,
    var authorityCodeId: LongFilter? = null,
    var distinct: Boolean? = null
) : Serializable, Criteria {

    constructor(other: StdAdminAuthorityCriteria) :
        this(
            other.id?.copy(),
            other.isDeleted?.copy(),
            other.createdBy?.copy(),
            other.createdDate?.copy(),
            other.lastModifiedBy?.copy(),
            other.lastModifiedDate?.copy(),
            other.authorityCodeId?.copy(),
            other.distinct
        )

    override fun copy() = StdAdminAuthorityCriteria(this)

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
