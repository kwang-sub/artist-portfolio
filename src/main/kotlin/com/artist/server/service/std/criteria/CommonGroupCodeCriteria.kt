package com.artist.server.service.std.criteria

import org.springdoc.api.annotations.ParameterObject
import tech.jhipster.service.Criteria
import tech.jhipster.service.filter.*
import java.io.Serializable

/**
 * Criteria class for the [com.artist.server.domain.StdCommonGroupCode] entity. This class is used in
 * [com.artist.server.web.rest.StdCommonGroupCodeResource] to receive all the possible filtering options from the
 * Http GET request parameters.
 * For example the following could be a valid request:
 * ```/std-common-group-codes?id.greaterThan=5&attr1.contains=something&attr2.specified=false```
 * As Spring is unable to properly convert the types, unless specific [Filter] class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
data class CommonGroupCodeCriteria(
    var commonGroupCode: StringFilter? = null,
    var commonGroupCodeName: StringFilter? = null,
    var commonGroupCodeDesc: StringFilter? = null,
    var sortNum: IntegerFilter? = null,
    var isActivated: BooleanFilter? = BooleanFilter(),
    var isDeleted: BooleanFilter? = BooleanFilter(),
    var createdBy: StringFilter? = null,
    var createdDate: ZonedDateTimeFilter? = null,
    var lastModifiedBy: StringFilter? = null,
    var lastModifiedDate: ZonedDateTimeFilter? = null,
    var distinct: Boolean? = null
) : Serializable, Criteria {

    constructor(other: CommonGroupCodeCriteria) : this(
        other.commonGroupCode?.copy(), other.commonGroupCodeName?.copy(), other.commonGroupCodeDesc?.copy(),
        other.sortNum?.copy(), other.isActivated?.copy(), other.isDeleted?.copy(), other.createdBy?.copy(),
        other.createdDate?.copy(), other.lastModifiedBy?.copy(), other.lastModifiedDate?.copy(), other.distinct
    )

    override fun copy() = CommonGroupCodeCriteria(this)

    companion object {

        private const val serialVersionUID: Long = 1L
    }
}
