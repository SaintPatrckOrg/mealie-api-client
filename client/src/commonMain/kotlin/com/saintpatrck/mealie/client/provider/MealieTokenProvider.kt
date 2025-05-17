package com.saintpatrck.mealie.client.provider

import com.saintpatrck.mealie.client.api.model.MealieBearerTokens

/**
 * Represents a provider of Mealie bearer tokens.
 */
interface MealieTokenProvider {
    /**
     * Gets the Mealie bearer tokens.
     */
    fun getMealieBearerTokens(): MealieBearerTokens?

    /**
     * Refreshes the Mealie bearer tokens.
     *
     * @param oldTokens The old Mealie bearer tokens.
     * @return The refreshed Mealie bearer tokens.
     */
    suspend fun refreshMealieBearerTokens(oldTokens: MealieBearerTokens?): MealieBearerTokens?
}