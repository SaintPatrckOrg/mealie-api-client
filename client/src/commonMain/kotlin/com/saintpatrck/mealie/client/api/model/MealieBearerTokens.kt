package com.saintpatrck.mealie.client.api.model

/**
 * Represents a set of bearer tokens for authentication.
 *
 * @property accessToken The access token.
 * @property refreshToken The refresh token.
 */
data class MealieBearerTokens(
    val accessToken: String,
    val refreshToken: String?,
)
