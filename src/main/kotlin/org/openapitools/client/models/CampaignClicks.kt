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
 * @param unitReference
 * @param rollup
 * @param limit
 * @param units
 * @param `data`
 * @param unit
 */

data class CampaignClicks(

    @Json(name = "unit_reference")
    val unitReference: kotlin.String? = null,

    @Json(name = "rollup")
    val rollup: kotlin.Boolean? = null,

    @Json(name = "limit")
    val limit: kotlin.Int? = null,

    @Json(name = "units")
    val units: kotlin.Int? = null,

    @Json(name = "data")
    val `data`: CampaignClicksData? = null,

    @Json(name = "unit")
    val unit: CampaignClicks.Unit? = null

) {

    /**
     *
     *
     * Values: minute,hour,day,week,month
     */
    enum class Unit(val value: kotlin.String) {
        @Json(name = "minute") minute("minute"),
        @Json(name = "hour") hour("hour"),
        @Json(name = "day") day("day"),
        @Json(name = "week") week("week"),
        @Json(name = "month") month("month");
    }
}