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
 * @param facet
 * @param unitReference
 * @param unit
 */

data class BaseScanMetrics(

    @Json(name = "units")
    val units: kotlin.Int? = null,

    @Json(name = "facet")
    val facet: BaseScanMetrics.Facet? = null,

    @Json(name = "unit_reference")
    val unitReference: kotlin.String? = null,

    @Json(name = "unit")
    val unit: kotlin.String? = null

) {

    /**
     *
     *
     * Values: countries,cities,deviceOs,browsers
     */
    enum class Facet(val value: kotlin.String) {
        @Json(name = "countries") countries("countries"),
        @Json(name = "cities") cities("cities"),
        @Json(name = "device_os") deviceOs("device_os"),
        @Json(name = "browsers") browsers("browsers");
    }
}
