package com.saintpatrck.mealie.client.api.user.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a response from creating an API token.
 *
 * @property name The name of the API token.
 * @property id The ID of the API token.
 * @property createdAt The date and time when the API token was created.
 * @property token The token value.
 */
@Serializable
data class CreateApiTokenResponseJson(
    @SerialName("name")
    val name: String,
    @SerialName("id")
    val id: Int,
    @SerialName("createdAt")
    val createdAt: Instant,
    @SerialName("token")
    val token: String,
)
