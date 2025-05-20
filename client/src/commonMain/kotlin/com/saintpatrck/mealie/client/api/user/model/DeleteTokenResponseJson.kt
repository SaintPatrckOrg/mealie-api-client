package com.saintpatrck.mealie.client.api.user.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models the response when deleting an API token.
 *
 * @property tokenDelete The token that was deleted.
 */
@Serializable
data class DeleteTokenResponseJson(
    @SerialName("tokenDelete")
    val tokenDelete: String,
)
