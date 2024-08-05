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
 * @param billingPeriod
 * @param effectiveEndDate
 * @param discountPercentage
 * @param endDateCondition
 * @param effectiveStartDate
 * @param upToPeriodsType
 * @param model
 * @param upToPeriods
 * @param productRatePlanChargeId
 * @param discountAmount
 */

data class SubscriptionDiscount(

    @Json(name = "billing_period")
    val billingPeriod: kotlin.String? = null,

    @Json(name = "effective_end_date")
    val effectiveEndDate: kotlin.String? = null,

    @Json(name = "discount_percentage")
    val discountPercentage: java.math.BigDecimal? = null,

    @Json(name = "end_date_condition")
    val endDateCondition: kotlin.String? = null,

    @Json(name = "effective_start_date")
    val effectiveStartDate: kotlin.String? = null,

    @Json(name = "up_to_periods_type")
    val upToPeriodsType: kotlin.String? = null,

    @Json(name = "model")
    val model: kotlin.String? = null,

    @Json(name = "up_to_periods")
    val upToPeriods: java.math.BigDecimal? = null,

    @Json(name = "product_rate_plan_charge_id")
    val productRatePlanChargeId: kotlin.String? = null,

    @Json(name = "discount_amount")
    val discountAmount: java.math.BigDecimal? = null

)
