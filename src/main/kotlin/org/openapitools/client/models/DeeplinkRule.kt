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
 * @param bitlink
 * @param installUrl
 * @param created ISO timestamp
 * @param appUriPath
 * @param modified ISO timestamp
 * @param installType
 * @param appGuid
 * @param guid
 * @param os
 * @param brandGuid
 */

data class DeeplinkRule(

    @Json(name = "bitlink")
    val bitlink: kotlin.String? = null,

    @Json(name = "install_url")
    val installUrl: kotlin.String? = null,

    /* ISO timestamp */
    @Json(name = "created")
    val created: kotlin.String? = null,

    @Json(name = "app_uri_path")
    val appUriPath: kotlin.String? = null,

    /* ISO timestamp */
    @Json(name = "modified")
    val modified: kotlin.String? = null,

    @Json(name = "install_type")
    val installType: kotlin.String? = null,

    @Json(name = "app_guid")
    val appGuid: kotlin.String? = null,

    @Json(name = "guid")
    val guid: kotlin.String? = null,

    @Json(name = "os")
    val os: kotlin.String? = null,

    @Json(name = "brand_guid")
    val brandGuid: kotlin.String? = null

)