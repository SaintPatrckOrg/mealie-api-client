package com.saintpatrck.mealie.client.api.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Response from the /auth/token endpoint.
 */
@Serializable
data class TokenResponseJson(
    @SerialName("access_token")
    val accessToken: String,

    @SerialName("token_type")
    val tokenType: String?,
)
