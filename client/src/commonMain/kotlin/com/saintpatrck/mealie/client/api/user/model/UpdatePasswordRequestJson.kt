package com.saintpatrck.mealie.client.api.user.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request to update the password of a user.
 *
 * @property currentPassword The current password of the user.
 * @property newPassword The new password for the user.
 */
@Serializable
data class UpdatePasswordRequestJson(
    @SerialName("currentPassword")
    val currentPassword: String,
    @SerialName("newPassword")
    val newPassword: String,
)
