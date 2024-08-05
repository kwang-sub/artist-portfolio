package com.artist.server.service.core.criteria

import org.springdoc.api.annotations.ParameterObject
import tech.jhipster.service.Criteria
import tech.jhipster.service.filter.*
import java.io.Serializable

/**
 * Criteria class for the [com.artist.server.domain.core.StdAdmin] entity. This class is used in
 * [com.artist.server.web.rest.core.StdAdminResource] to receive all the possible filtering options from the
 * Http GET request parameters.
 * For example the following could be a valid request:
 * ```/std-admins?id.greaterThan=5&attr1.contains=something&attr2.specified=false```
 * As Spring is unable to properly convert the types, unless specific [Filter] class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdAdminCriteria(
    var id: LongFilter? = null,
    var adminLoginId: StringFilter? = null,
    var adminPassword: StringFilter? = null,
    var adminUserName: StringFilter? = null,
    var adminPhoneNum: StringFilter? = null,
    var adminEmail: StringFilter? = null,
    var isActivated: BooleanFilter? = BooleanFilter(),
    var isDeleted: BooleanFilter? = BooleanFilter(),
    var createdBy: StringFilter? = null,
    var createdDate: ZonedDateTimeFilter? = null,
    var lastModifiedBy: StringFilter? = null,
    var lastModifiedDate: ZonedDateTimeFilter? = null,
    var hopHospitalId: LongFilter? = null,
    var hopHospitalDepartmentAdminId: LongFilter? = null,
    var stdAdminPasswordId: LongFilter? = null,
    var usrPatientId: LongFilter? = null,
    var distinct: Boolean? = null
) : Serializable, Criteria {

    constructor(other: StdAdminCriteria) :
        this(
            other.id?.copy(),
            other.adminLoginId?.copy(),
            other.adminPassword?.copy(),
            other.adminUserName?.copy(),
            other.adminPhoneNum?.copy(),
            other.adminEmail?.copy(),
            other.isActivated?.copy(),
            other.isDeleted?.copy(),
            other.createdBy?.copy(),
            other.createdDate?.copy(),
            other.lastModifiedBy?.copy(),
            other.lastModifiedDate?.copy(),
            other.hopHospitalId?.copy(),
            other.hopHospitalDepartmentAdminId?.copy(),
            other.stdAdminPasswordId?.copy(),
            other.usrPatientId?.copy(),
            other.distinct
        )

    override fun copy() = StdAdminCriteria(this)

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
