package com.saintpatrck.mealie.client.api.households.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models the request body for creating a new cookbook.
 */
@Serializable
data class CreateCookbookRequestJson(
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("position")
    val position: Int,
    @SerialName("public")
    val public: Boolean,
)
