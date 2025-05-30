package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a recipe tool.
 *
 * @property id The ID of the recipe tool.
 * @property name The name of the recipe tool.
 * @property slug The slug associated with the recipe tool.
 * @property householdsWithTool The list of households that have the tool.
 */
@Serializable
data class RecipeToolJson(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("householdsWithTool")
    val householdsWithTool: List<String>,
)
