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
 * INTERNAL_ERROR
 *
 * @param message
 * @param errors
 * @param resource
 * @param description
 */

data class InternalError(

    @Json(name = "message")
    val message: kotlin.String? = null,

    @Json(name = "errors")
    val errors: kotlin.collections.List<FieldError>? = null,

    @Json(name = "resource")
    val resource: kotlin.String? = null,

    @Json(name = "description")
    val description: kotlin.String? = null

)
