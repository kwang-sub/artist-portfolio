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
 * @param error
 * @param clicks
 * @param bitlinkId
 */

data class ClicksCount(

    @Json(name = "error")
    val error: kotlin.String? = null,

    @Json(name = "clicks")
    val clicks: kotlin.Int? = null,

    @Json(name = "bitlink_id")
    val bitlinkId: kotlin.String? = null

)