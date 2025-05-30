package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a request to create a recipe from a URL.
 *
 * @param includeTags Whether to include tags in the recipe.
 * @param url The URL to scrape.
 */
@Serializable
data class CreateRecipeFromUrlRequestJson(
    @SerialName("includeTags")
    val includeTags: Boolean,
    @SerialName("url")
    val url: String,
)
