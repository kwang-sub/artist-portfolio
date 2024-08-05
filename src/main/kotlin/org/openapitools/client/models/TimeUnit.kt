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
 * the unit of time queried for (minute, hour, day, week, month)
 *
 * Values: minute,hour,day,week,month
 */

enum class TimeUnit(val value: kotlin.String) {

    @Json(name = "minute")
    minute("minute"),

    @Json(name = "hour")
    hour("hour"),

    @Json(name = "day")
    day("day"),

    @Json(name = "week")
    week("week"),

    @Json(name = "month")
    month("month");

    /**
     * Override toString() to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is TimeUnit) "$data" else null

        /**
         * Returns a valid [TimeUnit] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): TimeUnit? = data?.let {
            val normalizedData = "$it".lowercase()
            values().firstOrNull { value ->
                it == value || normalizedData == "$value".lowercase()
            }
        }
    }
}
