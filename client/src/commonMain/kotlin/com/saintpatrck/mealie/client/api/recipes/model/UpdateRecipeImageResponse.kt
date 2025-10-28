package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Represents the response received after successfully updating a recipe's image.
 *
 * @property image The filename of the newly uploaded image.
 */
@Serializable
data class UpdateRecipeImageResponse(

    /**
     * Binary string representation of the image.
     */
    @SerialName("image")
    val image: String
)
