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
 * @param chargeAmount
 * @param processingType
 * @param taxAmount
 * @param chargeName
 */

data class Charges(

    @Json(name = "charge_amount")
    val chargeAmount: java.math.BigDecimal? = null,

    @Json(name = "processing_type")
    val processingType: kotlin.String? = null,

    @Json(name = "tax_amount")
    val taxAmount: java.math.BigDecimal? = null,

    @Json(name = "charge_name")
    val chargeName: kotlin.String? = null

)
