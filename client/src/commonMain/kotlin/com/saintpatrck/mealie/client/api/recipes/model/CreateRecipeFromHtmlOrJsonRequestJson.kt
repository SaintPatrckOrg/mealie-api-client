package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a request to create a recipe from an HTML or JSON string.
 */
@Serializable
data class CreateRecipeFromHtmlOrJsonRequestJson(
    @SerialName("includeTags")
    val includeTags: Boolean,
    @SerialName("data")
    val data: String,
)
