package com.saintpatrck.mealie.client.api.households.model

import com.saintpatrck.mealie.client.api.model.RecipeJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a cookbook with its associated recipes.
 *
 * @property id The ID of the cookbook.
 * @property name The name of the cookbook.
 * @property description The description of the cookbook.
 * @property slug The slug associated with the cookbook.
 * @property position The ordinal position of the cookbook when displayed in a list.
 * @property public Whether the cookbook is public.
 * @property queryFilterString The query filter string associated with the cookbook.
 * @property groupId The ID of the group that the cookbook belongs to.
 * @property householdId The ID of the household that the cookbook belongs to.
 * @property recipes The list of recipes in the cookbook.
 */
@Serializable
data class CookbookWithRecipesJson(
    @SerialName("id")
    val id: String,
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
    @SerialName("recipes")
    val recipes: List<RecipeJson>,
)
