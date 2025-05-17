package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models an API token associated with the user.
 *
 * @property id The ID of the token.
 * @property name The name of the token.
 * @property createdAt The date and time when the token was created.
 */
@Serializable
data class MealieToken(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("createdAt")
    val createdAt: String?,
)
