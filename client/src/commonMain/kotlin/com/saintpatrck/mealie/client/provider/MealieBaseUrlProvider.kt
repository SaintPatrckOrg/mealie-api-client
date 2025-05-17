package com.saintpatrck.mealie.client.provider

/**
 * Provides the base URL for the Mealie API.
 */
interface MealieBaseUrlProvider {
    /**
     * The base URL for the Mealie API.
     */
    val baseUrl: String
}