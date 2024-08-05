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
 * @param buttonTextColor
 * @param displayName
 * @param launchpadTextColor
 * @param descriptionColor
 * @param isActive
 * @param background
 * @param avatarBackground
 * @param themeId
 * @param buttonBackground
 */

data class LaunchpadPresetTheme(

    @Json(name = "button_text_color")
    val buttonTextColor: kotlin.String? = null,

    @Json(name = "display_name")
    val displayName: kotlin.String? = null,

    @Json(name = "launchpad_text_color")
    val launchpadTextColor: kotlin.String? = null,

    @Json(name = "description_color")
    val descriptionColor: kotlin.String? = null,

    @Json(name = "is_active")
    val isActive: kotlin.Boolean? = null,

    @Json(name = "background")
    val background: kotlin.String? = null,

    @Json(name = "avatar_background")
    val avatarBackground: kotlin.String? = null,

    @Json(name = "theme_id")
    val themeId: kotlin.Int? = null,

    @Json(name = "button_background")
    val buttonBackground: kotlin.String? = null

)
