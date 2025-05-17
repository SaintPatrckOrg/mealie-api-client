package com.saintpatrck.mealie.client.api.about.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the response of the app/about/theme endpoint.
 */
@Serializable
data class AppThemeResponseJson(
    @SerialName("lightPrimary")
    val lightPrimary: String,

    @SerialName("lightAccent")
    val lightAccent: String,

    @SerialName("lightSecondary")
    val lightSecondary: String,

    @SerialName("lightSuccess")
    val lightSuccess: String,

    @SerialName("lightInfo")
    val lightInfo: String,

    @SerialName("lightWarning")
    val lightWarning: String,

    @SerialName("lightError")
    val lightError: String,

    @SerialName("darkPrimary")
    val darkPrimary: String,

    @SerialName("darkAccent")
    val darkAccent: String,

    @SerialName("darkSecondary")
    val darkSecondary: String,

    @SerialName("darkSuccess")
    val darkSuccess: String,

    @SerialName("darkInfo")
    val darkInfo: String,

    @SerialName("darkWarning")
    val darkWarning: String,

    @SerialName("darkError")
    val darkError: String,
)
