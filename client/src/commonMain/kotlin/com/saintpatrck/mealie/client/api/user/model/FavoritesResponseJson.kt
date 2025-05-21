package com.saintpatrck.mealie.client.api.user.model

import com.saintpatrck.mealie.client.api.model.Rating
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a collection of user's favorites recipes.
 *
 * @property ratings The list of users favorite recipes.
 */
@Serializable
data class FavoritesResponseJson(
    @SerialName("ratings")
    val ratings: List<Rating>,
)
