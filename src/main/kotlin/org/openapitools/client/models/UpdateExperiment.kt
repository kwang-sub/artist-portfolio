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
 * @param cohortDescriptions
 * @param experimentDescription
 * @param startTime
 * @param isActive
 * @param incrementVersion
 * @param endTime
 * @param displayName
 */

data class UpdateExperiment(

    @Json(name = "cohort_descriptions")
    val cohortDescriptions: kotlin.collections.List<CohortDescription>? = null,

    @Json(name = "experiment_description")
    val experimentDescription: kotlin.String? = null,

    @Json(name = "start_time")
    val startTime: kotlin.String? = null,

    @Json(name = "is_active")
    val isActive: kotlin.Boolean? = null,

    @Json(name = "increment_version")
    val incrementVersion: kotlin.Boolean? = null,

    @Json(name = "end_time")
    val endTime: kotlin.String? = null,

    @Json(name = "display_name")
    val displayName: kotlin.String? = null

)