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
 * @param annualPromo
 * @param monthlyPromo
 * @param intervention
 */

data class EvaluateInterventionResponse(

    @Json(name = "annual_promo")
    val annualPromo: EvaluateInterventionResponseAnnualPromo? = null,

    @Json(name = "monthly_promo")
    val monthlyPromo: EvaluateInterventionResponseAnnualPromo? = null,

    @Json(name = "intervention")
    val intervention: kotlin.String? = null

)
