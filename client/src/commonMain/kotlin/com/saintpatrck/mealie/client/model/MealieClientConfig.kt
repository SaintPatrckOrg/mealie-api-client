package com.saintpatrck.mealie.client.model

import com.saintpatrck.mealie.client.MealieClient
import com.saintpatrck.mealie.client.api.model.MealieBearerTokens
import com.saintpatrck.mealie.client.platform
import com.saintpatrck.mealie.client.provider.MealieBaseUrlProvider
import com.saintpatrck.mealie.client.provider.MealieTokenProvider
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.logging.LoggingConfig

/**
 * Represents a configuration for the [MealieClient].
 */
class MealieClientConfig {
    /**
     * The engine used by the client.
     */
    var engine: HttpClientEngine = platform.httpClientEngineConfig

    /**
     * Provides the base URL to use for API requests.
     */
    var baseUrlProvider: MealieBaseUrlProvider? = null

    /**
     * Provides the access tokens to use for API requests.
     */
    var accessTokenProvider: () -> MealieBearerTokens? = { null }

    /**
     * Provides the refresh tokens to use for API requests.
     */
    var refreshTokenProvider: suspend (oldTokens: MealieBearerTokens?) -> MealieBearerTokens? =
        { null }
    private var mealieTokenProvider: MealieTokenProvider? = null
    internal var loggingConfig: LoggingConfig.() -> Unit = { }
        private set

    fun mealieTokenProvider(
        accessTokens: () -> MealieBearerTokens,
        refreshTokens: (oldTokens: MealieBearerTokens?) -> MealieBearerTokens?,
    ) {
        mealieTokenProvider = object : MealieTokenProvider {
            override fun getMealieBearerTokens() = accessTokens()

            override suspend fun refreshMealieBearerTokens(
                oldTokens: MealieBearerTokens?,
            ) = refreshTokens(oldTokens)
        }
    }

    fun loggingConfig(config: LoggingConfig.() -> Unit) {
        loggingConfig = config
    }
}
