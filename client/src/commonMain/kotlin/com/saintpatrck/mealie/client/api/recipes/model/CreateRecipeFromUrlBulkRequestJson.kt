package com.saintpatrck.mealie.client.api.recipes.model

import com.saintpatrck.mealie.client.api.model.RecipeCategoryJson
import com.saintpatrck.mealie.client.api.model.RecipeTagJson
import com.saintpatrck.mealie.client.api.recipes.RecipesApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The request model for the [RecipesApi.createFromUrlBulk] endpoint.
 *
 * @property imports The list of URLs to import.
 */
@Serializable
data class CreateRecipeFromUrlBulkRequestJson(
    @SerialName("imports")
    val imports: List<Import>,
) {

    /**
     * The request model for the [RecipesApi.createFromUrlBulk] endpoint.
     *
     * @property url The URL to import.
     * @property categories The list of categories to import.
     * @property tags The list of tags to import.
     */
    @Serializable
    data class Import(
        @SerialName("url")
        val url: String,
        @SerialName("categories")
        val categories: List<RecipeCategoryJson>,
        @SerialName("tags")
        val tags: List<RecipeTagJson>,
    )
}
