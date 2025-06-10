package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models an asset for a recipe.
 */
@Serializable
data class RecipeAssetJson(
    @SerialName("name")
    val name: String,
    @SerialName("icon")
    val icon: String,
    @SerialName("fileName")
    val fileName: String,
)
