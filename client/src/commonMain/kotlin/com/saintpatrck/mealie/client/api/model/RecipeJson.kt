package com.saintpatrck.mealie.client.api.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a recipe in a cookbook.
 *
 * @property id The ID of the recipe.
 * @property userId The ID of the user who added the recipe.
 * @property householdId The ID of the household that the recipe belongs to.
 * @property groupId The ID of the group that the recipe belongs to.
 * @property name The name of the recipe.
 * @property slug The slug associated with the recipe.
 * @property image The image associated with the recipe.
 * @property recipeServings The number of servings in the recipe.
 * @property recipeYieldQuantity The quantity of the recipe yield.
 * @property recipeYield The yield of the recipe.
 * @property totalTime The total time it takes to make the recipe.
 * @property prepTime The preparation time of the recipe.
 * @property cookTime The cooking time of the recipe.
 * @property performTime The active time required for the recipe.
 * @property description The description of the recipe.
 * @property recipeCategory The categories the recipe belongs to.
 * @property tags The tags associated with the recipe.
 * @property tools The tools required to make the recipe.
 * @property rating The overall rating of the recipe.
 * @property orgUrl The original URL associated with the recipe.
 * @property dateAdded The date when the recipe was added.
 * @property dateUpdated The date when the recipe was last updated.
 * @property createdAt The creation date of the recipe.
 * @property updatedAt The last update date of the recipe.
 * @property lastMade The date when the recipe was last made.
 */
@Serializable
data class RecipeJson(
    @SerialName("id")
    val id: String,
    @SerialName("userId")
    val userId: String,
    @SerialName("householdId")
    val householdId: String,
    @SerialName("groupId")
    val groupId: String,
    @SerialName("name")
    val name: String?,
    @SerialName("slug")
    val slug: String,
    @SerialName("image")
    val image: ByteArray?,
    @SerialName("recipeServings")
    val recipeServings: Double,
    @SerialName("recipeYieldQuantity")
    val recipeYieldQuantity: Double,
    @SerialName("recipeYield")
    val recipeYield: String?,
    @SerialName("totalTime")
    val totalTime: String?,
    @SerialName("prepTime")
    val prepTime: String?,
    @SerialName("cookTime")
    val cookTime: String?,
    @SerialName("performTime")
    val performTime: String?,
    @SerialName("description")
    val description: String,
    @SerialName("recipeCategory")
    val recipeCategory: List<RecipeCategoryJson>,
    @SerialName("tags")
    val tags: List<RecipeTagJson>,
    @SerialName("tools")
    val tools: List<RecipeToolJson>,
    @SerialName("rating")
    val rating: Double?,
    @SerialName("orgURL")
    val orgUrl: String?,
    @SerialName("dateAdded")
    val dateAdded: String,
    @SerialName("dateUpdated")
    val dateUpdated: Instant,
    @SerialName("createdAt")
    val createdAt: Instant,
    @SerialName("updatedAt")
    val updatedAt: Instant,
    @SerialName("lastMade")
    val lastMade: Instant,
)
