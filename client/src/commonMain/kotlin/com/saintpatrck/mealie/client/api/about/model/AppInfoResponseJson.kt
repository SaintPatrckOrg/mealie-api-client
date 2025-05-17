package com.saintpatrck.mealie.client.api.about.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the response from the /app/about endpoint.
 */
@Serializable
data class AppInfoResponseJson(
    @SerialName("production")
    val production: Boolean,

    @SerialName("version")
    val version: String,

    @SerialName("demoStatus")
    val demoStatus: Boolean,

    @SerialName("allowSignup")
    val allowSignup: Boolean,

    @SerialName("enableOidc")
    val enableOidc: Boolean,

    @SerialName("oidcRedirect")
    val oidcRedirect: Boolean,

    @SerialName("oidcProviderName")
    val oidcProviderName: String,

    @SerialName("enableOpenai")
    val enableOpenai: Boolean,

    @SerialName("enableOpenaiImageServices")
    val enableOpenaiImageServices: Boolean,

    @SerialName("defaultGroupSlug")
    val defaultGroupSlug: String? = null,

    @SerialName("defaultHouseholdSlug")
    val defaultHouseholdSlug: String? = null,
)
