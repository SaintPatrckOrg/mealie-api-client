package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a recipe instruction.
 */
@Serializable
data class RecipeInstructionJson(
    @SerialName("id")
    val id: String? = null,
    @SerialName("title")
    val title: String = "",
    @SerialName("text")
    val text: String,
    @SerialName("ingredientReferences")
    val ingredientReferences: List<String> = emptyList(),
)
