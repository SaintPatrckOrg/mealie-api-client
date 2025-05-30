package com.saintpatrck.mealie.client.api.recipes

import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST

/**
 * The API for managing recipe information.
 */
interface RecipesApi {
    @Headers("Content-Type: application/json")
    @POST("recipes/test-scrape-url")
    suspend fun testScrapeUrl(
        @Body testScrapeUrlRequest: TestScrapeUrlRequestJson,
    ): MealieResponse<TestScrapeUrlResponseJson>
}
