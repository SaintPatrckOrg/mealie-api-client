package com.saintpatrck.mealie.client.api.households.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a cookbook with its associated recipes.
 *
 * @property id The ID of the cookbook.
 * @property name The name of the cookbook.
 * @property description The description of the cookbook.
 * @property slug The slug associated with the cookbook.
 * @property position The ordinal position of the cookbook when displayed in a list.
 * @property public Whether the cookbook is public.
 * @property queryFilterString The query filter string associated with the cookbook.
 * @property groupId The ID of the group that the cookbook belongs to.
 * @property householdId The ID of the household that the cookbook belongs to.
 * @property recipes The list of recipes in the cookbook.
 */
@Serializable
data class CookbookWithRecipesJson(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("position")
    val position: Int,
    @SerialName("public")
    val public: Boolean,
    @SerialName("queryFilterString")
    val queryFilterString: String,
    @SerialName("groupId")
    val groupId: String,
    @SerialName("householdId")
    val householdId: String,
    @SerialName("recipes")
    val recipes: List<RecipeJson>,
) {
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
        val recipeCategory: List<RecipeCategory>,
        @SerialName("tags")
        val tags: List<RecipeTag>,
        @SerialName("tools")
        val tools: List<RecipeTool>,
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
    ) {
        /**
         * Models a recipe category.
         *
         * @property id The ID of the recipe category.
         * @property name The name of the recipe category.
         * @property slug The slug associated with the recipe category.
         */
        @Serializable
        data class RecipeCategory(
            @SerialName("id")
            val id: String,
            @SerialName("name")
            val name: String,
            @SerialName("slug")
            val slug: String,
        )

        /**
         * Models a recipe tag.
         *
         * @property id The ID of the recipe tag.
         * @property name The name of the recipe tag.
         * @property slug The slug associated with the recipe tag.
         */
        @Serializable
        data class RecipeTag(
            @SerialName("id")
            val id: String,
            @SerialName("name")
            val name: String,
            @SerialName("slug")
            val slug: String,
        )

        /**
         * Models a recipe tool.
         *
         * @property id The ID of the recipe tool.
         * @property name The name of the recipe tool.
         * @property slug The slug associated with the recipe tool.
         * @property householdsWithTool The list of households that have the tool.
         */
        @Serializable
        data class RecipeTool(
            @SerialName("id")
            val id: String,
            @SerialName("name")
            val name: String,
            @SerialName("slug")
            val slug: String,
            @SerialName("householdsWithTool")
            val householdsWithTool: List<String>,
        )
    }
}
