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
 * @param status
 * @param domain
 * @param price
 * @param zone
 */

data class DomainStatus(

    @Json(name = "status")
    val status: DomainStatus.Status? = null,

    @Json(name = "domain")
    val domain: kotlin.String? = null,

    @Json(name = "price")
    val price: kotlin.String? = null,

    @Json(name = "zone")
    val zone: kotlin.String? = null

) {

    /**
     *
     *
     * Values: unavailable,available,complimentary
     */
    enum class Status(val value: kotlin.String) {
        @Json(name = "unavailable") unavailable("unavailable"),
        @Json(name = "available") available("available"),
        @Json(name = "complimentary") complimentary("complimentary");
    }
}