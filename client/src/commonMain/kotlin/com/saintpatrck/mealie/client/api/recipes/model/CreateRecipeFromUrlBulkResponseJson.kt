package com.saintpatrck.mealie.client.api.recipes.model

import com.saintpatrck.mealie.client.api.recipes.RecipesApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The response model for the [RecipesApi.createFromUrlBulk] endpoint.
 *
 * @property reportId The ID of the report that was created.
 */
@Serializable
data class CreateRecipeFromUrlBulkResponseJson(
    @SerialName("reportId")
    val reportId: String,
)
