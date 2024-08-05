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
 * @param hideBitlyLogo
 * @param launchpadId
 * @param backgroundImageUrl
 * @param themeId
 * @param layout
 * @param description
 * @param launchpadTextColor
 * @param socialIconColor
 * @param descriptionColor
 * @param backgroundImageAlignment
 * @param displayName
 * @param buttonAppearance
 * @param avatarImageUrl
 * @param avatarUploadImage
 * @param stylePreference
 * @param background
 * @param socialIconPosition
 * @param backgroundUploadImage
 * @param font
 * @param socialIconLayoutPosition
 */

data class LaunchpadAppearance(

    @Json(name = "hide_bitly_logo")
    val hideBitlyLogo: kotlin.Boolean,

    @Json(name = "launchpad_id")
    val launchpadId: kotlin.String? = null,

    @Json(name = "background_image_url")
    val backgroundImageUrl: kotlin.String? = null,

    @Json(name = "theme_id")
    val themeId: kotlin.Int? = null,

    @Json(name = "layout")
    val layout: kotlin.String? = null,

    @Json(name = "description")
    val description: kotlin.String? = null,

    @Json(name = "launchpad_text_color")
    val launchpadTextColor: kotlin.String? = null,

    @Json(name = "social_icon_color")
    val socialIconColor: LaunchpadAppearance.SocialIconColor? = null,

    @Json(name = "description_color")
    val descriptionColor: kotlin.String? = null,

    @Json(name = "background_image_alignment")
    val backgroundImageAlignment: LaunchpadAppearance.BackgroundImageAlignment? = null,

    @Json(name = "display_name")
    val displayName: kotlin.String? = null,

    @Json(name = "button_appearance")
    val buttonAppearance: LaunchpadButtonAppearance? = null,

    @Json(name = "avatar_image_url")
    val avatarImageUrl: kotlin.String? = null,

    @Json(name = "avatar_upload_image")
    val avatarUploadImage: kotlin.String? = null,

    @Json(name = "style_preference")
    val stylePreference: LaunchpadAppearance.StylePreference? = null,

    @Json(name = "background")
    val background: kotlin.String? = null,

    @Json(name = "social_icon_position")
    val socialIconPosition: LaunchpadAppearance.SocialIconPosition? = null,

    @Json(name = "background_upload_image")
    val backgroundUploadImage: kotlin.String? = null,

    @Json(name = "font")
    val font: kotlin.String? = null,

    @Json(name = "social_icon_layout_position")
    val socialIconLayoutPosition: LaunchpadAppearance.SocialIconLayoutPosition? = null

) {

    /**
     *
     *
     * Values: color,black,white
     */
    enum class SocialIconColor(val value: kotlin.String) {
        @Json(name = "color") color("color"),
        @Json(name = "black") black("black"),
        @Json(name = "white") white("white");
    }
    /**
     *
     *
     * Values: stretch,fit,repeat
     */
    enum class BackgroundImageAlignment(val value: kotlin.String) {
        @Json(name = "stretch") stretch("stretch"),
        @Json(name = "fit") fit("fit"),
        @Json(name = "repeat") repeat("repeat");
    }
    /**
     *
     *
     * Values: custom,theme,image
     */
    enum class StylePreference(val value: kotlin.String) {
        @Json(name = "custom") custom("custom"),
        @Json(name = "theme") theme("theme"),
        @Json(name = "image") image("image");
    }
    /**
     *
     *
     * Values: top,bottom
     */
    enum class SocialIconPosition(val value: kotlin.String) {
        @Json(name = "top") top("top"),
        @Json(name = "bottom") bottom("bottom");
    }
    /**
     *
     *
     * Values: icon,button
     */
    enum class SocialIconLayoutPosition(val value: kotlin.String) {
        @Json(name = "icon") icon("icon"),
        @Json(name = "button") button("button");
    }
}