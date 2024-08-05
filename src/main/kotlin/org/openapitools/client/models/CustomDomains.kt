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
 * @param upgradeRequired
 * @param customDomains
 */

data class CustomDomains(

    @Json(name = "upgrade_required")
    val upgradeRequired: kotlin.Boolean? = null,

    @Json(name = "custom_domains")
    val customDomains: kotlin.collections.List<CustomDomainBody>? = null

)