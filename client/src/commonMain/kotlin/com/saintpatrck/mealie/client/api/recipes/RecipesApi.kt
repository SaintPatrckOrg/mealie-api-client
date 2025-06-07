package com.saintpatrck.mealie.client.api.recipes

import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.OrderByNullPosition
import com.saintpatrck.mealie.client.api.model.OrderDirection
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.RecipeJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromHtmlOrJsonRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkResponseJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.Multipart
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Query
import io.ktor.client.request.forms.MultiPartFormDataContent

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

    /**
     * Creates a recipe from a zip file.
     */
    @Multipart
    @POST("recipes/create/zip")
    suspend fun createFromZip(
        @Body archive: MultiPartFormDataContent,
    ): MealieResponse<Unit>

    /**
     * Creates a recipe from an image using OpenAI. Optionally, specify a language for it to
     * translate the recipe to.
     */
    @Multipart
    @POST("recipes/create/image")
    suspend fun createFromImage(
        @Query("translateLanguage")
        translateLanguage: String?,
        @Body image: MultiPartFormDataContent,
    ): MealieResponse<Unit>

    /**
     * Retrieve paged recipes.
     */
    @GET("recipes")
    suspend fun getRecipes(
        @Query("categories")
        categories: List<String>? = null,
        @Query("tags")
        tags: List<String>? = null,
        @Query("tools")
        tools: List<String>? = null,
        @Query("foods")
        foods: List<String>? = null,
        @Query("households")
        households: List<String>? = null,
        @Query("cookbook")
        cookbook: String? = null,
        @Query("requireAllCategories")
        requireAllCategories: Boolean = false,
        @Query("requireAllTags")
        requireAllTags: Boolean = false,
        @Query("requireAllTools")
        requireAllTools: Boolean = false,
        @Query("requireAllFoods")
        requireAllFoods: Boolean = false,
        @Query("search")
        search: String? = null,
        @Query("orderBy")
        orderBy: String? = null,
        @Query("orderByNullPosition")
        orderByNullPosition: OrderByNullPosition? = null,
        @Query("orderDirection")
        orderDirection: OrderDirection = OrderDirection.DESC,
        @Query("paginationSeed")
        paginationSeed: String? = null,
        @Query("page")
        page: Int = 1,
        @Query("perPage")
        perPage: Int = 50,
    ): MealieResponse<PagedResponseJson<RecipeJson>>
}
