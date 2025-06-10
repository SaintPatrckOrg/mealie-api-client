package com.saintpatrck.mealie.client.api.recipes.model

import com.saintpatrck.mealie.client.api.model.MultiPurposeLabelSummaryJson
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * Models a recipe ingredient.
 */
@Serializable
data class RecipeIngredientJson(
    @SerialName("quantity")
    val quantity: Double? = 1.0,
    @SerialName("unit")
    val unit: IngredientUnitJson? = null,
    @SerialName("food")
    val food: IngredientFoodJson? = null,
    @SerialName("note")
    val note: String? = null,
    @SerialName("isFood")
    val isFood: Boolean? = null,
    @SerialName("disableAmount")
    val disableAmount: Boolean = true,
    @SerialName("display")
    val display: String = "",
    @SerialName("title")
    val title: String? = null,
    @SerialName("originalText")
    val originalText: String? = null,
    @SerialName("referenceId")
    val referenceId: String,
) {


    /**
     * Models an ingredient food.
     */
    @Serializable
    data class IngredientFoodJson(
        @SerialName("id")
        val id: String,
        @SerialName("name")
        val name: String,
        @SerialName("pluralName")
        val pluralName: String,
        @SerialName("description")
        val description: String,
        @SerialName("extras")
        val extras: String,
        @SerialName("labelId")
        val labelId: String,
        @SerialName("aliases")
        val aliases: List<String> = emptyList(),
        @SerialName("householdsWithIngredientFood")
        val householdsWithIngredientFood: List<String> = emptyList(),
        @SerialName("label")
        val label: MultiPurposeLabelSummaryJson,
        @SerialName("createdAt")
        val createdAt: Instant? = null,
        @SerialName("updatedAt")
        @JsonNames("update_at")
        val updatedAt: Instant? = null,
    )

    /**
     * Models an ingredient unit of measure.
     */
    @Serializable
    data class IngredientUnitJson(
        @SerialName("id")
        val id: String,
        @SerialName("name")
        val name: String,
        @SerialName("pluralName")
        val pluralName: String,
        @SerialName("description")
        val description: String,
        @SerialName("extras")
        val extras: String,
        @SerialName("fraction")
        val fraction: Boolean = true,
        @SerialName("abbreviation")
        val abbreviation: String = "",
        @SerialName("pluralAbbreviation")
        val pluralAbbreviation: String = "",
        @SerialName("useAbbreviation")
        val useAbbreviation: Boolean = false,
        @SerialName("aliases")
        val aliases: List<String> = emptyList(),
        @SerialName("createdAt")
        val createdAt: Instant? = null,
        @SerialName("updatedAt")
        @JsonNames("update_at")
        val updatedAt: Instant? = null,
    )
}
