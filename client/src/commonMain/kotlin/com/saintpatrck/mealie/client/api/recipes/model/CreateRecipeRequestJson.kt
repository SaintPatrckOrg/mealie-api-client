package com.saintpatrck.mealie.client.api.recipes.model

import com.saintpatrck.mealie.client.api.model.RecipeCategoryJson
import com.saintpatrck.mealie.client.api.model.RecipeTagJson
import com.saintpatrck.mealie.client.api.model.RecipeToolJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a request to create a recipe.
 */
@Serializable
data class CreateRecipeRequestJson(
    @SerialName("name")
    val name: String,
    @SerialName("householdId")
    val householdId: String? = null,
    @SerialName("groupId")
    val groupId: String? = null,
    @SerialName("recipeYield")
    val recipeYield: String? = null,
    @SerialName("totalTime")
    val totalTime: String? = null,
    @SerialName("prepTime")
    val prepTime: String? = null,
    @SerialName("cookTime")
    val cookTime: String? = null,
    @SerialName("performTime")
    val performTime: String? = null,
    @SerialName("recipeCategory")
    val recipeCategory: List<RecipeCategoryJson> = emptyList(),
    @SerialName("tags")
    val tags: List<RecipeTagJson> = emptyList(),
    @SerialName("tools")
    val tools: List<RecipeToolJson> = emptyList(),
    @SerialName("rating")
    val rating: Double? = null,
)
