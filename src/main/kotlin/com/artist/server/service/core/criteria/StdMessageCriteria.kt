package com.artist.server.service.core.criteria

import org.springdoc.api.annotations.ParameterObject
import tech.jhipster.service.Criteria
import tech.jhipster.service.filter.*
import java.io.Serializable

/**
 * Criteria class for the [com.artist.server.domain.StdMessage] entity. This class is used in
 * [com.artist.server.web.rest.StdMessageResource] to receive all the possible filtering options from the
 * Http GET request parameters.
 * For example the following could be a valid request:
 * ```/std-messages?id.greaterThan=5&attr1.contains=something&attr2.specified=false```
 * As Spring is unable to properly convert the types, unless specific [Filter] class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdMessageCriteria(
    var id: LongFilter? = null,
    var messageTypeCode: StringFilter? = null,
    var messageCode: StringFilter? = null,
    var messageContent: StringFilter? = null,
    var sortOrder: IntegerFilter? = null,
    var isActivated: BooleanFilter? = BooleanFilter(),
    var isDeleted: BooleanFilter? = BooleanFilter(),
    var createdBy: StringFilter? = null,
    var createdDate: ZonedDateTimeFilter? = null,
    var lastModifiedBy: StringFilter? = null,
    var lastModifiedDate: ZonedDateTimeFilter? = null,
    var distinct: Boolean? = null
) : Serializable, Criteria {

    constructor(other: StdMessageCriteria) :
        this(
            other.id?.copy(),
            other.messageTypeCode?.copy(),
            other.messageCode?.copy(),
            other.messageContent?.copy(),
            other.sortOrder?.copy(),
            other.isActivated?.copy(),
            other.isDeleted?.copy(),
            other.createdBy?.copy(),
            other.createdDate?.copy(),
            other.lastModifiedBy?.copy(),
            other.lastModifiedDate?.copy(),
            other.distinct
        )

    override fun copy() = StdMessageCriteria(this)

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
