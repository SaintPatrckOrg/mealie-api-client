package com.saintpatrck.mealie.client.api.households.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a cookbook.
 */
@Serializable
data class CookbooksResponseJson(
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
    @SerialName("queryFilterString")
    val queryFilterString: String,
    @SerialName("groupId")
    val groupId: String,
    @SerialName("householdId")
    val householdId: String,
    @SerialName("id")
    val id: String,
)
