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
 * @param units
 * @param totalClicks
 * @param unitReference
 * @param unit
 */

data class GroupBitlinksCountRollup(

    @Json(name = "units")
    val units: kotlin.Int? = null,

    @Json(name = "total_clicks")
    val totalClicks: kotlin.Int? = null,

    @Json(name = "unit_reference")
    val unitReference: kotlin.String? = null,

    @Json(name = "unit")
    val unit: kotlin.String? = null

)
