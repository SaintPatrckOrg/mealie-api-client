package com.saintpatrck.mealie.client.infrastructure.ktorfit

import com.saintpatrck.mealie.client.api.model.MealieBearerTokens
import com.saintpatrck.mealie.client.infrastructure.converter.MealieResponseConverterFactory
import com.saintpatrck.mealie.client.platform
import com.saintpatrck.mealie.client.provider.MealieTokenProvider
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.LoggingConfig
import io.ktor.client.plugins.plugin
import io.ktor.http.Url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Creates a new [Ktorfit] instance for the Mealie API.
 *
 * @param baseUrlProvider The provider for the base URL.
 * @param mealieTokenProvider The provider for the Mealie tokens.
 * @param engine The [HttpClientEngine] to use.
 * @param loggingConfig The logging configuration.
 */
internal fun mealieKtorfit(
    baseUrlProvider: () -> String,
    mealieTokenProvider: MealieTokenProvider?,
    engine: HttpClientEngine = platform.httpClientEngineConfig,
    loggingConfig: (LoggingConfig.() -> Unit) = { },
) = ktorfit {
    baseUrl(baseUrlProvider())
    httpClient(
        client = HttpClient(engine) {
            install(plugin = Auth) {
                bearer {
                    loadTokens {
                        mealieTokenProvider
                            ?.getMealieBearerTokens()
                            ?.toBearerTokens()
                    }
                    refreshTokens {
                        mealieTokenProvider
                            ?.refreshMealieBearerTokens(
                                oldTokens = oldTokens.toMealieTokensOrNull()
                            )
                            ?.toBearerTokens()
                    }
                }
            }
            install(plugin = ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(plugin = Logging) { loggingConfig(this) }
            converterFactories(
                converters = arrayOf(
                    MealieResponseConverterFactory,
                ),
            )
        }
            .also { client ->
                client
                    .plugin(HttpSend)
                    .intercept { request ->
                        val baseUrl = Url(baseUrlProvider())
                        execute(
                            request.apply {
                                url.host = baseUrl.host
                                url.port = baseUrl.port
                            }
                        )
                    }
            }
    )
}

private fun MealieBearerTokens.toBearerTokens(): BearerTokens =
    BearerTokens(accessToken, refreshToken)

private fun BearerTokens?.toMealieTokensOrNull(): MealieBearerTokens? =
    this
        ?.let {
            MealieBearerTokens(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken,
            )
        }
