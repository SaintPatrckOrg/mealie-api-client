package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
