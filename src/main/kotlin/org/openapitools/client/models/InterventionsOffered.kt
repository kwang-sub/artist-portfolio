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
 * @param interventionResponse
 * @param interventionValue
 * @param interventionType
 */

data class InterventionsOffered(

    @Json(name = "intervention_response")
    val interventionResponse: kotlin.String? = null,

    @Json(name = "intervention_value")
    val interventionValue: kotlin.String? = null,

    @Json(name = "intervention_type")
    val interventionType: kotlin.String? = null

)