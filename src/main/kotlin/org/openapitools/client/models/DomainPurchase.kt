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
 * @param orderId
 * @param domain
 * @param vendor
 * @param orgGuid
 * @param created ISO timestamp
 */

data class DomainPurchase(

    @Json(name = "order_id")
    val orderId: kotlin.Int? = null,

    @Json(name = "domain")
    val domain: kotlin.String? = null,

    @Json(name = "vendor")
    val vendor: kotlin.String? = null,

    @Json(name = "org_guid")
    val orgGuid: kotlin.String? = null,

    /* ISO timestamp */
    @Json(name = "created")
    val created: kotlin.String? = null

)
