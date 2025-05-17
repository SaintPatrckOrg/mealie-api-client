package com.saintpatrck.mealie.client.api.registration.model

import kotlinx.serialization.Serializable

/**
 * Represents the authentication method used by the user.
 */
@Serializable
enum class MealieAuthMethod {
    MEALIE,
    LDAP,
    OIDC,
}
