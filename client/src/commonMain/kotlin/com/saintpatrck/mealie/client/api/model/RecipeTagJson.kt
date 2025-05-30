package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a recipe tag.
 *
 * @property id The ID of the recipe tag.
 * @property name The name of the recipe tag.
 * @property slug The slug associated with the recipe tag.
 */
@Serializable
data class RecipeTagJson(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
)
