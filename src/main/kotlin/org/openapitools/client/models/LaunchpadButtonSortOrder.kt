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
 * @param sortOrder
 * @param buttonId
 */

data class LaunchpadButtonSortOrder(

    @Json(name = "sort_order")
    val sortOrder: kotlin.Int,

    @Json(name = "button_id")
    val buttonId: kotlin.String

)
