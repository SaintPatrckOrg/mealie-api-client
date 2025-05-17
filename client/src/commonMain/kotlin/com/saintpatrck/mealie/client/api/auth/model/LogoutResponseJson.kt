package com.saintpatrck.mealie.client.api.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a response from the logout endpoint.
 */
@Serializable
data class LogoutResponseJson(
    @SerialName("message")
    val message: String,
)
