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
 * @param subscriptionID
 * @param orgGuid
 */

data class AnnualRenewalReminderRequest(

    @Json(name = "subscription_ID")
    val subscriptionID: kotlin.String? = null,

    @Json(name = "org_guid")
    val orgGuid: kotlin.String? = null

)