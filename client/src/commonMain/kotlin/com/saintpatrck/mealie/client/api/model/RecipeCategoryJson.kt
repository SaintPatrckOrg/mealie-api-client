package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a recipe category.
 *
 * @property id The ID of the recipe category.
 * @property name The name of the recipe category.
 * @property slug The slug associated with the recipe category.
 */
@Serializable
data class RecipeCategoryJson(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
)
