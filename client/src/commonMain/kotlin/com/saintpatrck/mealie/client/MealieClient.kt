package com.saintpatrck.mealie.client

import com.saintpatrck.mealie.client.api.about.AboutApi
import com.saintpatrck.mealie.client.api.about.createAboutApi
import com.saintpatrck.mealie.client.api.auth.AuthApi
import com.saintpatrck.mealie.client.api.auth.createAuthApi
import com.saintpatrck.mealie.client.api.households.HouseholdsApi
import com.saintpatrck.mealie.client.api.households.createHouseholdsApi
import com.saintpatrck.mealie.client.api.model.MealieBearerTokens
import com.saintpatrck.mealie.client.api.user.UserApi
import com.saintpatrck.mealie.client.api.user.createUserApi
import com.saintpatrck.mealie.client.infrastructure.ktorfit.mealieKtorfit
import com.saintpatrck.mealie.client.model.MealieClientConfig
import com.saintpatrck.mealie.client.provider.MealieTokenProvider
import de.jensklingenberg.ktorfit.Ktorfit

/**
 * Creates a new [MealieClient] with the given [config].
 */
fun mealieClient(
    config: MealieClientConfig.() -> Unit = {},
): MealieClient = MealieClient(
    MealieClientConfig().apply(config)
)

/**
 * Represents a client for the Mealie API.
 */
class MealieClient internal constructor(
    private val mealieClientConfig: MealieClientConfig,
) {
    private val ktorfit: Ktorfit by lazy {
        mealieKtorfit(
            baseUrlProvider = {
                mealieClientConfig.baseUrlProvider?.baseUrl.orEmpty()
            },
            mealieTokenProvider = object : MealieTokenProvider {
                override fun getMealieBearerTokens() =
                    mealieClientConfig.accessTokenProvider()

                override suspend fun refreshMealieBearerTokens(
                    oldTokens: MealieBearerTokens?,
                ) =
                    mealieClientConfig.refreshTokenProvider(oldTokens)
            },
            engine = mealieClientConfig.engine,
            loggingConfig = {
                apply(mealieClientConfig.loggingConfig)
            },
        )
    }

    /**
     * The API for retrieving information about the Mealie instance.
     */
    val aboutApi: AboutApi by lazy {
        ktorfit.createAboutApi()
    }

    /**
     * The API for authenticating with the Mealie instance.
     */
    val authApi: AuthApi by lazy {
        ktorfit.createAuthApi()
    }

    /**
     * The API for user CRUD operations.
     */
    val userApi: UserApi by lazy {
        ktorfit.createUserApi()
    }

    /**
     * The API for managing household information.
     */
    val householdsApi: HouseholdsApi by lazy {
        ktorfit.createHouseholdsApi()
    }
}
