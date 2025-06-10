package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models settings for a recipe.
 */
@Serializable
data class RecipeSettingsJson(
    @SerialName("public")
    val public: Boolean = false,
    @SerialName("showNutrition")
    val showNutrition: Boolean = false,
    @SerialName("showAssets")
    val showAssets: Boolean = false,
    @SerialName("landscapeView")
    val landscapeView: Boolean = false,
    @SerialName("disableComments")
    val disableComments: Boolean = true,
    @SerialName("disableAmount")
    val disableAmount: Boolean = true,
    @SerialName("locked")
    val locked: Boolean = false,
)
