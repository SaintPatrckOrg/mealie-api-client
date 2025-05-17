package com.saintpatrck.mealie.client.api.user.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the response from the /users/self/ratings endpoint.
 *
 * @property ratings The list of ratings.
 */
@Serializable
data class SelfRatingsResponseJson(
    @SerialName("ratings")
    val ratings: List<Rating>,
) {
    /**
     * Represents a rating for a recipe.
     *
     * @property recipeId The ID of the recipe.
     * @property rating The rating given to the recipe.
     * @property isFavorite Whether the recipe is a favorite.
     */
    @Serializable
    data class Rating(
        @SerialName("recipeId")
        val recipeId: String,
        @SerialName("rating")
        val rating: Double,
        @SerialName("isFavorite")
        val isFavorite: Boolean,
    )
}
