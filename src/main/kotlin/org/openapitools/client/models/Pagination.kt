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
 * @param total
 * @param propertySize
 * @param prev
 * @param page
 * @param next
 */

data class Pagination(

    @Json(name = "total")
    val total: kotlin.Int? = null,

    @Json(name = "size")
    val propertySize: kotlin.Int? = null,

    @Json(name = "prev")
    val prev: kotlin.String? = null,

    @Json(name = "page")
    val page: kotlin.Int? = null,

    @Json(name = "next")
    val next: kotlin.String? = null

)
