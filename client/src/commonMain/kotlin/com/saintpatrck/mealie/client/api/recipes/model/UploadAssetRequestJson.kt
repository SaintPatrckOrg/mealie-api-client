package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the JSON body for an asset upload request.
 *
 * @property name The name of the asset.
 * @property icon The icon associated with the asset.
 * @property extension The file extension of the asset (e.g., "jpg", "png").
 * @property file The base64 encoded string of the file content.
 */
@Serializable
data class UploadAssetRequestJson(
    /**
     * The name of the asset.
     */
    @SerialName("name")
    val name: String,
    /**
     * The icon associated with the asset.
     */
    @SerialName("icon")
    val icon: String,
    /**
     * The file extension of the asset (e.g., "jpg", "png").
     */
    @SerialName("extension")
    val extension: String,
    /**
     * The base64 encoded string of the file content.
     */
    @SerialName("file")
    val file: String,
)
