package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a scraped recipe.
 */
@Serializable
data class TestScrapeUrlResponseJson(
    @SerialName("@context")
    val context: String,
    @SerialName("@type")
    val type: String,
    @SerialName("name")
    val name: String,
    @SerialName("image")
    val image: List<String>,
    @SerialName("description")
    val description: String?,
    @SerialName("prepTime")
    val prepTime: String?,
    @SerialName("cookTime")
    val cookTime: String?,
    @SerialName("totalTime")
    val totalTime: String?,
    @SerialName("recipeYield")
    val recipeYield: String?,
    @SerialName("author")
    val author: String?,
    @SerialName("recipeCategory")
    val recipeCategory: String?,
    @SerialName("recipeIngredient")
    val recipeIngredient: List<String>?,
    @SerialName("recipeInstructions")
    val recipeInstructions: List<InstructionJson>?,
) {

    /**
     * Models a scraped recipe's instruction.
     */
    @Serializable
    data class InstructionJson(
        @SerialName("@type")
        val type: String,
        @SerialName("text")
        val text: String?,
    )
}
