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
 * @param otherCityScans
 * @param noCityScans
 */

data class OtherScanMetrics(

    @Json(name = "other_city_scans")
    val otherCityScans: kotlin.Int? = null,

    @Json(name = "no_city_scans")
    val noCityScans: kotlin.Int? = null

)