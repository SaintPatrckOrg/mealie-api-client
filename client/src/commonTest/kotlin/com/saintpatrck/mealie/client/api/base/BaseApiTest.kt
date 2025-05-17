package com.saintpatrck.mealie.client.api.base

import com.saintpatrck.mealie.client.api.model.MealieBearerTokens
import com.saintpatrck.mealie.client.mealieClient
import com.saintpatrck.mealie.client.provider.MealieBaseUrlProvider
import com.saintpatrck.mealie.client.provider.MealieTokenProvider
import createMockEngine
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf

/**
 * Base class for Ktorfit tests.
 */
abstract class BaseApiTest {

    var urlProvider = object : MealieBaseUrlProvider {
        override val baseUrl: String = "http://localhost:9925/"
    }

    var mealieTokenProvider = object : MealieTokenProvider {
        override fun getMealieBearerTokens(): MealieBearerTokens? {
            return MealieBearerTokens("accessToken", "refreshToken")
        }

        override suspend fun refreshMealieBearerTokens(oldTokens: MealieBearerTokens?): MealieBearerTokens? {
            return MealieBearerTokens("accessToken", "refreshToken")
        }
    }

    val mealieClientLogger = object : Logger {
        override fun log(message: String) {
            println(message)
        }
    }

    fun createTestMealieClient(
        responseJson: String,
        status: HttpStatusCode = HttpStatusCode.OK,
        headers: Headers = headersOf(HttpHeaders.ContentType, "application/json"),
    ) = mealieClient {
        engine = createMockEngine(
            response = responseJson,
            status = status,
            headers = headers,
        )
        baseUrlProvider = urlProvider
        accessTokenProvider = {
            mealieTokenProvider.getMealieBearerTokens()
        }
        refreshTokenProvider = { oldTokens ->
            mealieTokenProvider.refreshMealieBearerTokens(oldTokens)
        }
        mealieTokenProvider(
            accessTokens = {
                MealieBearerTokens("accessToken", "refreshToken")
            },
            refreshTokens = {
                MealieBearerTokens("accessToken", "refreshToken")
            }
        )
        loggingConfig {
            logger = mealieClientLogger
            level = LogLevel.ALL
        }
    }
}