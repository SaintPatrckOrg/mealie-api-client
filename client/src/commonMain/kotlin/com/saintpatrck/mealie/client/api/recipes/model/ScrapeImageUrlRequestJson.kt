package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * A data class representing the JSON body for a request to scrape a recipe from a URL.
 *
 * @property includeTags Whether to include tags from the scraped recipe.
 * @property url The URL of the recipe to scrape.
 */
@Serializable
data class ScrapeImageUrlRequestJson(
    /** Whether to include tags from the scraped recipe. */
    @SerialName("includeTags")
    val includeTags: Boolean,

    /** The URL of the image to scrape. */
    @SerialName("url")
    val url: String,
)
