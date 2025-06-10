package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models nutritional information for a recipe.
 */
@Serializable
data class RecipeNutritionJson(
    @SerialName("calories")
    val calories: String?,
    @SerialName("carbohydrateContent")
    val carbohydrateContent: String?,
    @SerialName("cholesterolContent")
    val cholesterolContent: String?,
    @SerialName("fatContent")
    val fatContent: String?,
    @SerialName("fiberContent")
    val fiberContent: String?,
    @SerialName("proteinContent")
    val proteinContent: String?,
    @SerialName("saturatedFatContent")
    val saturatedFatContent: String?,
    @SerialName("sodiumContent")
    val sodiumContent: String?,
    @SerialName("sugarContent")
    val sugarContent: String?,
    @SerialName("unsaturatedFatContent")
    val unsaturatedFatContent: String?,
)
