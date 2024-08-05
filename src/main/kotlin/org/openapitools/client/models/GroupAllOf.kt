/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models

import com.squareup.moshi.Json

/**
 *
 *
 * @param name
 * @param bsds
 * @param created
 * @param isActive
 * @param modified
 * @param organizationGuid
 * @param role
 * @param guid
 */

data class GroupAllOf(

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "bsds")
    val bsds: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "created")
    val created: kotlin.String? = null,

    @Json(name = "is_active")
    val isActive: kotlin.Boolean? = null,

    @Json(name = "modified")
    val modified: kotlin.String? = null,

    @Json(name = "organization_guid")
    val organizationGuid: kotlin.String? = null,

    @Json(name = "role")
    val role: kotlin.String? = null,

    @Json(name = "guid")
    val guid: kotlin.String? = null

)
