package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class representing the request body for updating a recipe's image.
 *
 * @property image A base64 encoded string of the image.
 * @property extensions The file extension of the image (e.g., "jpg", "png").
 */
@Serializable
data class UpdateRecipeImageRequest(
    /**
     * A base64 encoded string of the image.
     */
    @SerialName("image")
    val image: String,

    /**
     * The file extension of the image.
     */
    @SerialName("extension")
    val extension: String
)
