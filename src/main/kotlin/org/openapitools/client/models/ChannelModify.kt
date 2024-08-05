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
 * @param groupGuid
 * @param guid
 * @param name
 * @param modified ISO_TIMESTAMP
 * @param created ISO TIMESTAMP
 * @param bitlinks
 */

data class ChannelModify(

    @Json(name = "group_guid")
    val groupGuid: kotlin.String? = null,

    @Json(name = "guid")
    val guid: kotlin.String? = null,

    @Json(name = "name")
    val name: kotlin.String? = null,

    /* ISO_TIMESTAMP */
    @Json(name = "modified")
    val modified: kotlin.String? = null,

    /* ISO TIMESTAMP */
    @Json(name = "created")
    val created: kotlin.String? = null,

    @Json(name = "bitlinks")
    val bitlinks: kotlin.collections.List<BaseChannelBitlink>? = null

)
