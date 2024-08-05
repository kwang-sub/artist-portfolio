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
 * @param countryName
 * @param ISO3
 * @param ISO2
 * @param callingCode
 */

data class CountryCode(

    @Json(name = "CountryName")
    val countryName: kotlin.String? = null,

    @Json(name = "ISO3")
    val ISO3: kotlin.String? = null,

    @Json(name = "ISO2")
    val ISO2: kotlin.String? = null,

    @Json(name = "CallingCode")
    val callingCode: kotlin.Int? = null

)