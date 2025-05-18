package com.saintpatrck.mealie.client.api.admin.model

import com.saintpatrck.mealie.client.api.registration.model.MealieAuthMethod
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a user to be created.
 */
@Serializable
data class CreateUserRequestJson(
    @SerialName("username")
    val username: String,
    @SerialName("fullName")
    val fullName: String,
    @SerialName("email")
    val email: String,
    @SerialName("authMethod")
    val authMethod: MealieAuthMethod = MealieAuthMethod.MEALIE,
    @SerialName("admin")
    val admin: Boolean = false,
    @SerialName("group")
    val group: String,
    @SerialName("household")
    val household: String,
    @SerialName("advanced")
    val advanced: Boolean = false,
    @SerialName("canInvite")
    val canInvite: Boolean = false,
    @SerialName("canManage")
    val canManage: Boolean = false,
    @SerialName("canManageHousehold")
    val canManageHousehold: Boolean = false,
    @SerialName("canOrganize")
    val canOrganize: Boolean = false,
    @SerialName("password")
    val password: String,
)
