package com.saintpatrck.mealie.client

import io.ktor.client.engine.HttpClientEngine

/**
 * Represents the platform on which the client app is running.
 */
internal interface Platform {
    /**
     * The name of the platform.
     */
    val name: String

    /**
     * The configuration for the platform's HTTP client engine.
     */
    val httpClientEngineConfig: HttpClientEngine
}

/**
 * Gets the current platform information.
 */
internal expect val platform: Platform
