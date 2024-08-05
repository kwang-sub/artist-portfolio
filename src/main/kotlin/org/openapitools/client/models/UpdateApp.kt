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
 * @param ipAllowlist
 * @param redirectUris
 * @param link
 * @param name
 * @param description
 */

data class UpdateApp(

    @Json(name = "ip_allowlist")
    val ipAllowlist: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "redirect_uris")
    val redirectUris: kotlin.collections.List<kotlin.String>? = null,

    @Json(name = "link")
    val link: kotlin.String? = null,

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "description")
    val description: kotlin.String? = null

)
