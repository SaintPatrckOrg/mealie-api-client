package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the response from the server after uploading a recipe asset (e.g., an image).
 *
 * @property name The original name of the uploaded file.
 * @property fileName The new, processed filename on the server.
 */
@Serializable
data class UploadAssetResponseJson(

    /**
     * The original name of the uploaded file.
     */
    @SerialName("name")
    val name: String,

    /**
     * The new, processed filename on the server.
     */
    @SerialName("fileName")
    val fileName: String,
)
