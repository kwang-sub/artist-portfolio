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
 * @param country
 * @param region
 * @param subregion
 * @param city
 * @param scans
 */

data class CityScanMetric(

    @Json(name = "country")
    val country: kotlin.String? = null,

    @Json(name = "region")
    val region: kotlin.String? = null,

    @Json(name = "subregion")
    val subregion: kotlin.String? = null,

    @Json(name = "city")
    val city: kotlin.String? = null,

    @Json(name = "scans")
    val scans: kotlin.Int? = null

)