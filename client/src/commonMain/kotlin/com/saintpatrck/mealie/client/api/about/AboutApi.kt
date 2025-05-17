package com.saintpatrck.mealie.client.api.about

import com.saintpatrck.mealie.client.api.about.model.AppInfoResponseJson
import com.saintpatrck.mealie.client.api.about.model.AppThemeResponseJson
import com.saintpatrck.mealie.client.api.about.model.StartupInfoResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import de.jensklingenberg.ktorfit.http.GET

/**
 * Represents the API for retrieving information about the app.
 */
interface AboutApi {

    /**
     * Retrieves information about the app.
     */
    @GET("app/about")
    suspend fun aboutApp(): MealieResponse<AppInfoResponseJson>

    /**
     * Retrieves startup information of the app.
     */
    @GET("app/about/startup-info")
    suspend fun startupInfo(): MealieResponse<StartupInfoResponseJson>

    /**
     * Retrieves the theme of the app.
     */
    @GET("app/about/theme")
    suspend fun theme(): MealieResponse<AppThemeResponseJson>
}
