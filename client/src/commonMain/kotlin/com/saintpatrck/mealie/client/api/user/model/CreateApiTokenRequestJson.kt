package com.saintpatrck.mealie.client.api.user.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request to create an API token.
 *
 * @property name The name of the API token.
 * @property integrationId The ID of the integration associated with the API token.
 */
@Serializable
data class CreateApiTokenRequestJson(
    @SerialName("name")
    val name: String,
    @SerialName("integrationId")
    val integrationId: String,
)
