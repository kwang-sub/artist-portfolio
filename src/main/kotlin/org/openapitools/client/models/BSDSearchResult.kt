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
 * @param type
 * @param domain
 * @param subdomain
 * @param link
 * @param zone
 */

data class BSDSearchResult(

    @Json(name = "type")
    val type: BSDSearchResult.Type? = null,

    @Json(name = "domain")
    val domain: kotlin.String? = null,

    @Json(name = "subdomain")
    val subdomain: kotlin.String? = null,

    @Json(name = "link")
    val link: kotlin.String? = null,

    @Json(name = "zone")
    val zone: kotlin.String? = null

) {

    /**
     *
     *
     * Values: affiliate,reseller
     */
    enum class Type(val value: kotlin.String) {
        @Json(name = "affiliate") affiliate("affiliate"),
        @Json(name = "reseller") reseller("reseller");
    }
}
