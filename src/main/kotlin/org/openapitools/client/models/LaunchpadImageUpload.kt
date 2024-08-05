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
 * @param position
 * @param image
 * @param crop
 */

data class LaunchpadImageUpload(

    @Json(name = "position")
    val position: LaunchpadImageUpload.Position? = null,

    @Json(name = "image")
    val image: java.io.File? = null,

    @Json(name = "crop")
    val crop: kotlin.String? = null

) {

    /**
     *
     *
     * Values: profile,background
     */
    enum class Position(val value: kotlin.String) {
        @Json(name = "profile") profile("profile"),
        @Json(name = "background") background("background");
    }
}
