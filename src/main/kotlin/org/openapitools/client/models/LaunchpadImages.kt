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
 * @param profile
 * @param background
 */

data class LaunchpadImages(

    @Json(name = "profile")
    val profile: LaunchpadImage? = null,

    @Json(name = "background")
    val background: LaunchpadImage? = null

)