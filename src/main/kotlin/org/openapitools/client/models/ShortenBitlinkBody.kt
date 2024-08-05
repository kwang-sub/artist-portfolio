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
 * @param references
 * @param archived
 * @param tags
 * @param createdAt
 * @param deeplinks
 * @param longUrl
 * @param customBitlinks list of previously edited backhalfs for the bitlink
 * @param link
 * @param id
 */

data class ShortenBitlinkBody(

    @Json(name = "references")
    val references: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,

    @Json(name = "archived")
    val archived: kotlin.Boolean? = null,

    @Json(name = "tags")
    val tags: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "created_at")
    val createdAt: kotlin.String? = null,

    @Json(name = "deeplinks")
    val deeplinks: kotlin.collections.List<DeeplinkRule>? = null,

    @Json(name = "long_url")
    val longUrl: kotlin.String? = null,

    /* list of previously edited backhalfs for the bitlink */
    @Json(name = "custom_bitlinks")
    val customBitlinks: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "link")
    val link: kotlin.String? = null,

    @Json(name = "id")
    val id: kotlin.String? = null

)