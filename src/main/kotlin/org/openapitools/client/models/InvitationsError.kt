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
 * @param message
 * @param emails
 */

data class InvitationsError(

    @Json(name = "message")
    val message: kotlin.String? = null,

    @Json(name = "emails")
    val emails: kotlin.collections.List<kotlin.String>? = null

)
