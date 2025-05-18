package com.saintpatrck.mealie.client.api.password.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request to send a password reset link to a given [email] if it belongs to a user.
 *
 * @property email The email address to send the reset link to.
 */
@Serializable
data class ForgotPasswordRequestJson(
    @SerialName("email")
    val email: String,
)
