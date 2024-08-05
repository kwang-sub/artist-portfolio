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
 * the tier default values for a single access feature
 *
 * @param hasAccess
 * @param name
 */

data class DefaultAccessFeature(

    @Json(name = "has_access")
    val hasAccess: kotlin.Boolean? = null,

    @Json(name = "name")
    val name: kotlin.String? = null

)