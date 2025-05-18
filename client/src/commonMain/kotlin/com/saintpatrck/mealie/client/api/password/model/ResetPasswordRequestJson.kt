package com.saintpatrck.mealie.client.api.password.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request to reset a password.
 *
 * @property token The token to reset the password with.
 * @property email The email address to reset the password for.
 * @property password The new password.
 * @property passwordConfirm The new password confirmation.
 */
@Serializable
data class ResetPasswordRequestJson(
    @SerialName("token")
    val token: String,
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String,
    @SerialName("passwordConfirm")
    val passwordConfirm: String,
)
