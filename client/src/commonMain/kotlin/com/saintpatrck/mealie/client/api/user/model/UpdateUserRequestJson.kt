package com.saintpatrck.mealie.client.api.user.model

import com.saintpatrck.mealie.client.api.registration.model.MealieAuthMethod
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request to update a user's information.
 */
@Serializable
data class UpdateUserRequestJson(
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
    val group: String?,
    @SerialName("household")
    val household: String?,
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
)
