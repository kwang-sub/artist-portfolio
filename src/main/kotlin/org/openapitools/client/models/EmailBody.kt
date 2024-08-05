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
 * @param isPrimary
 * @param email
 */

data class EmailBody(

    @Json(name = "status")
    val status: kotlin.String? = null,

    @Json(name = "is_primary")
    val isPrimary: kotlin.Boolean? = null,

    @Json(name = "email")
    val email: kotlin.String? = null

)