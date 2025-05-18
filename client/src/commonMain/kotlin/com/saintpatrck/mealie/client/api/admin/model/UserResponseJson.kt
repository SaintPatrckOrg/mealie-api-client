package com.saintpatrck.mealie.client.api.admin.model

import com.saintpatrck.mealie.client.api.model.MealieToken
import com.saintpatrck.mealie.client.api.registration.model.MealieAuthMethod
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a user response from the get user API.
 */
@Serializable
data class UserResponseJson(
    @SerialName("id")
    val id: String,
    @SerialName("username")
    val username: String?,
    @SerialName("fullName")
    val fullName: String?,
    @SerialName("email")
    val email: String,
    @SerialName("authMethod")
    val authMethod: MealieAuthMethod,
    @SerialName("admin")
    val admin: Boolean,
    @SerialName("group")
    val group: String,
    @SerialName("household")
    val household: String,
    @SerialName("advanced")
    val advanced: Boolean,
    @SerialName("canInvite")
    val canInvite: Boolean,
    @SerialName("canManage")
    val canManage: Boolean,
    @SerialName("canManageHousehold")
    val canManageHousehold: Boolean,
    @SerialName("canOrganize")
    val canOrganize: Boolean,
    @SerialName("groupId")
    val groupId: String,
    @SerialName("groupSlug")
    val groupSlug: String,
    @SerialName("householdId")
    val householdId: String,
    @SerialName("householdSlug")
    val householdSlug: String,
    @SerialName("tokens")
    val tokens: List<MealieToken>,
    @SerialName("cacheKey")
    val cacheKey: String,
)
