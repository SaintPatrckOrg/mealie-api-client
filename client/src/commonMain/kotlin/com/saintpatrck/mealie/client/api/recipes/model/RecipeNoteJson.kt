package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a note for a recipe.
 */
@Serializable
data class RecipeNoteJson(
    @SerialName("title")
    val title: String,
    @SerialName("text")
    val text: String,
)
