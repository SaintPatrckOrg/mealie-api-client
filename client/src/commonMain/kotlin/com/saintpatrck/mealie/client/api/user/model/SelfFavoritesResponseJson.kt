package com.saintpatrck.mealie.client.api.user.model

import com.saintpatrck.mealie.client.api.model.Rating
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the response from the /users/self/favorites endpoint.
 *
 * @property ratings The list of users favorite recipes.
 */
@Serializable
data class SelfFavoritesResponseJson(
    @SerialName("ratings")
    val ratings: List<Rating>,
)
