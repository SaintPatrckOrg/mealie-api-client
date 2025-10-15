package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

/**
 * Models a recipe last made date.
 */
@Serializable
data class RecipeLastMadeJson(
    @SerialName("timestamp")
    val timestamp: Instant,
)
