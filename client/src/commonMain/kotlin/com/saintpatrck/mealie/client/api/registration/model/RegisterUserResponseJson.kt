package com.saintpatrck.mealie.client.api.registration.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a response from the login endpoint.
 *
 * @property id The ID of the user.
 * @property email The email of the user.
 * @property username The username of the user.
 * @property fullName The full name of the user.
 * @property authMethod The authentication method used by the user.
 * @property admin Whether the user is an admin.
 * @property group The name of the group the user belongs to.
 * @property household The name of the household the user belongs to.
 * @property advanced Whether the user has advanced settings enabled.
 * @property canInvite Whether the user can invite other users.
 * @property canManage Whether the user can manage other users.
 * @property canManageHousehold Whether the user can manage the household.
 * @property canOrganize Whether the user can organize events.
 * @property groupId The ID of the group the user belongs to.
 * @property groupSlug The slug of the group the user belongs to.
 * @property householdId The ID of the household the user belongs to.
 * @property householdSlug The slug of the household the user belongs to.
 * @property tokens The tokens associated with the user.
 * @property cacheKey The cache key associated with the user.
 */
@Serializable
data class RegisterUserResponseJson(
    @SerialName("id")
    val id: String,
    @SerialName("email")
    val email: String,
    @SerialName("username")
    val username: String?,
    @SerialName("fullName")
    val fullName: String?,
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
) {
    /**
     * Models an API token associated with the user.
     *
     * @property id The ID of the token.
     * @property name The name of the token.
     * @property createdAt The date and time when the token was created.
     */
    @Serializable
    data class MealieToken(
        @SerialName("id")
        val id: String,
        @SerialName("name")
        val name: String,
        @SerialName("createdAt")
        val createdAt: String?,
    )
}
