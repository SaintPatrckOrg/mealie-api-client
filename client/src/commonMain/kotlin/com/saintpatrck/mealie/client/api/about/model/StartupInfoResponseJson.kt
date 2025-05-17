package com.saintpatrck.mealie.client.api.about.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a response from the app/about/startup-info endpoint.
 */
@Serializable
data class StartupInfoResponseJson(
    @SerialName("isFirstLogin")
    val isFirstLogin: Boolean,

    @SerialName("isDemo")
    val isDemo: Boolean,
)
