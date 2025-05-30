package com.saintpatrck.mealie.client.api.recipes

import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromHtmlOrJsonRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkResponseJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST

/**
 * The API for managing recipe information.
 */
interface RecipesApi {

    /**
     * Test parse a URL for recipe information.
     */
    @Headers("Content-Type: application/json")
    @POST("recipes/test-scrape-url")
    suspend fun testScrapeUrl(
        @Body testScrapeUrlRequest: TestScrapeUrlRequestJson,
    ): MealieResponse<TestScrapeUrlResponseJson>

    /**
     * Create a recipe from an HTML or JSON string.
     */
    @Headers("Content-Type: application/json")
    @POST("recipes/create/html-or-json")
    suspend fun createFromHtmlOrJson(
        @Body request: CreateRecipeFromHtmlOrJsonRequestJson,
    ): MealieResponse<String?>

    /**
     * Creates a recipe from a URL.
     *
     * @return The identifying slug of the created recipe.
     */
    @Headers("Content-Type: application/json")
    @POST("recipes/create/url")
    suspend fun createRecipeFromUrl(
        @Body request: CreateRecipeFromUrlRequestJson,
    ): MealieResponse<String>

    /**
     * Creates multiple recipes from a list of URLs.
     */
    @Headers("Content-Type: application/json")
    @POST("recipes/create/url/bulk")
    suspend fun createFromUrlBulk(
        @Body request: CreateRecipeFromUrlBulkRequestJson,
    ): MealieResponse<CreateRecipeFromUrlBulkResponseJson>
}
