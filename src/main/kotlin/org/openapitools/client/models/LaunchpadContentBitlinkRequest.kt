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
 * @param content
 * @param isActive
 * @param scheduleStart
 * @param scheduleEnd
 */

data class LaunchpadContentBitlinkRequest(

    @Json(name = "content")
    val content: LaunchpadContentBitlinkRequestContent? = null,

    @Json(name = "is_active")
    val isActive: kotlin.Boolean? = null,

    @Json(name = "schedule_start")
    val scheduleStart: kotlin.String? = null,

    @Json(name = "schedule_end")
    val scheduleEnd: kotlin.String? = null

)