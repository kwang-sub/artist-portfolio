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
 * custom domain in validation queue
 *
 * @param customDomain
 * @param organizationGuid
 * @param groupGuids
 * @param prevalidate
 */

data class DomainValidateBody(

    @Json(name = "custom_domain")
    val customDomain: kotlin.String,

    @Json(name = "organization_guid")
    val organizationGuid: kotlin.String,

    @Json(name = "group_guids")
    val groupGuids: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "prevalidate")
    val prevalidate: kotlin.Boolean? = null

)
