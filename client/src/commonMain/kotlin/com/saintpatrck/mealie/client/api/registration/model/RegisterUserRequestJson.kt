package com.saintpatrck.mealie.client.api.registration.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request to register a user.
 *
 * @property group The name of the group to register the user in.
 * @property household The name of the household to register the user in.
 * @property groupToken The group token to register the user in.
 * @property email The email of the user.
 * @property username The username of the user.
 * @property fullName The full name of the user.
 * @property password The password of the user.
 * @property passwordConfirm The password, again.
 * @property advanced Whether the user can view advanced settings. Defaults to false.
 * @property private Whether the users profile is private. Defaults to false.
 * @property seedData Whether the user should be seeded with data. Defaults to false.
 * @property locale The locale of the user. Defaults to "en-US".
 */
@Serializable
data class RegisterUserRequestJson(
    @SerialName("group")
    val group: String?,
    @SerialName("household")
    val household: String?,
    @SerialName("groupToken")
    val groupToken: String?,
    @SerialName("email")
    val email: String,
    @SerialName("username")
    val username: String,
    @SerialName("fullName")
    val fullName: String,
    @SerialName("password")
    val password: String,
    @SerialName("passwordConfirm")
    val passwordConfirm: String,
    @SerialName("advanced")
    val advanced: Boolean = false,
    @SerialName("private")
    val private: Boolean = false,
    @SerialName("seedData")
    val seedData: Boolean = false,
    @SerialName("locale")
    val locale: String = "en-US",
)
