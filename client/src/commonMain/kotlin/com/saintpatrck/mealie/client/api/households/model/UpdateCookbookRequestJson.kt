package com.saintpatrck.mealie.client.api.households.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a request to update a cookbook.
 *
 * @property name The name of the cookbook.
 * @property description The description of the cookbook.
 * @property slug The slug associated with the cookbook.
 * @property position The ordinal position of the cookbook when displayed in a list.
 * @property public Whether the cookbook is public.
 * @property queryFilterString The query filter string associated with the cookbook.
 */
@Serializable
data class UpdateCookbookRequestJson(
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("slug")
    val slug: String?,
    @SerialName("position")
    val position: Int,
    @SerialName("public")
    val public: Boolean,
    @SerialName("queryFilterString")
    val queryFilterString: String?,
)
