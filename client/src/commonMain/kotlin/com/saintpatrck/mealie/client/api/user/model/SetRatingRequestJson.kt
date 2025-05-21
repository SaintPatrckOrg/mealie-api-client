package com.saintpatrck.mealie.client.api.user.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a request to set the rating for a recipe.
 */
@Serializable
data class SetRatingRequestJson(
    @SerialName("rating")
    val rating: Double,
    @SerialName("isFavorite")
    val isFavorite: Boolean,
)
