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
 * @param cohort
 * @param cohortDescription
 */

data class CohortDescription(

    @Json(name = "cohort")
    val cohort: kotlin.Int? = null,

    @Json(name = "cohort_description")
    val cohortDescription: kotlin.String? = null

)