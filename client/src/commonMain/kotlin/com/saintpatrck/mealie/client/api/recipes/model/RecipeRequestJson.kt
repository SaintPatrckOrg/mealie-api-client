package com.saintpatrck.mealie.client.api.recipes.model

import com.saintpatrck.mealie.client.api.model.RecipeCategoryJson
import com.saintpatrck.mealie.client.api.model.RecipeTagJson
import com.saintpatrck.mealie.client.api.model.RecipeToolJson
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a recipe request.
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
data class RecipeRequestJson(
    @SerialName("id")
    val id: String? = null,
    @SerialName("userId")
    val userId: String,
    @SerialName("householdId")
    val householdId: String,
    @SerialName("groupId")
    val groupId: String,
    @SerialName("name")
    val name: String? = null,
    @SerialName("slug")
    val slug: String = "",
    @SerialName("image")
    val image: String? = null,
    @SerialName("recipeServings")
    val recipeServings: Double = 0.0,
    @SerialName("recipeYieldQuantity")
    val recipeYieldQuantity: Double = 0.0,
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
    @SerialName("description")
    val description: String = "",
    @SerialName("recipeCategory")
    val recipeCategory: List<RecipeCategoryJson>? = emptyList(),
    @SerialName("tags")
    val tags: List<RecipeTagJson>? = emptyList(),
    @SerialName("tools")
    val tools: List<RecipeToolJson> = emptyList(),
    @SerialName("rating")
    val rating: Double? = null,
    @SerialName("orgURL")
    val orgUrl: String? = null,
    @SerialName("dateAdded")
    val dateAdded: String? = null,
    @SerialName("dateUpdated")
    val dateUpdated: Instant? = null,
    @SerialName("createdAt")
    val createdAt: Instant? = null,
    @SerialName("updatedAt")
    val updatedAt: Instant? = null,
    @SerialName("lastMade")
    val lastMade: Instant? = null,
    @SerialName("recipeIngredients")
    val recipeIngredients: List<RecipeIngredientJson>? = emptyList(),
    @SerialName("recipeInstructions")
    val recipeInstructions: List<RecipeInstructionJson>? = emptyList(),
    @SerialName("nutrition")
    val nutrition: RecipeNutritionJson? = null,
    @SerialName("settings")
    val settings: RecipeSettingsJson? = null,
    @SerialName("assets")
    val assets: List<RecipeAssetJson>? = emptyList(),
    @SerialName("notes")
    val notes: List<RecipeNoteJson>? = emptyList(),
    @SerialName("extras")
    val extras: String? = null,
    @SerialName("comments")
    val comments: List<CommentJson>? = emptyList(),
) {
    /**
     * Models a comment for a recipe.
     */
    @Serializable
    data class CommentJson(
        @SerialName("recipeId")
        val recipeId: String,
        @SerialName("text")
        val text: String,
        @SerialName("id")
        val id: String,
        @SerialName("createdAt")
        val createdAt: String,
        @SerialName("updated_at")
        val updatedAt: String,
        @SerialName("userId")
        val userId: String,
        @SerialName("user")
        val user: UserJson,
    ) {
        /**
         * Models a recipe comment's user.
         */
        @Serializable
        data class UserJson(
            @SerialName("id")
            val id: String,
            @SerialName("username")
            val username: String,
            @SerialName("admin")
            val admin: Boolean,
            @SerialName("fullName")
            val fullName: String,
        )
    }
}
