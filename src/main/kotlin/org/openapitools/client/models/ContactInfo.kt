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
 * @param firstName
 * @param lastName
 * @param address
 */

data class ContactInfo(

    @Json(name = "first_name")
    val firstName: kotlin.String,

    @Json(name = "last_name")
    val lastName: kotlin.String,

    @Json(name = "address")
    val address: BillingAddress

)
