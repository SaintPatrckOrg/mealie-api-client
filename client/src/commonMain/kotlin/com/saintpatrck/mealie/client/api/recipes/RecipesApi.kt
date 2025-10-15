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
import com.saintpatrck.mealie.client.api.recipes.model.RecipeRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.Multipart
import de.jensklingenberg.ktorfit.http.PATCH
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.PUT
import de.jensklingenberg.ktorfit.http.Path
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
     *
     * @param categories a list of categories to filter by. Defaults to `null`.
     * @param tags a list of tags to filter by. Defaults to `null`.
     * @param tools a list of tools to filter by. Defaults to `null`.
     * @param foods a list of foods to filter by. Defaults to `null`.
     * @param households a list of households to filter by. Defaults to `null`.
     * @param cookbook the cookbook to filter by. Defaults to `null`.
     * @param requireAllCategories whether to require all categories in the list. Defaults to `false`.
     * @param requireAllTags whether to require all tags in the list. Defaults to `false`.
     * @param requireAllTools whether to require all tools in the list. Defaults to `false`.
     * @param requireAllFoods whether to require all foods in the list. Defaults to `false`.
     * @param search the search query. Defaults to `null`.
     * @param orderBy the field to order by. Defaults to `null`.
     * @param orderByNullPosition the position of null values in the ordering. Defaults to `null`.
     * @param orderDirection the direction of the ordering. Defaults to [OrderDirection.DESC].
     * @param paginationSeed the seed for pagination. Defaults to `null`.
     * @param page the page number. Defaults to `1`.
     * @param perPage the number of items per page. Defaults to `50`.
     *
     * @return a paged list of recipes
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

    /**
     * Retrieve a single recipe by its slug or ID.
     *
     * @param slug The slug or ID of the recipe to retrieve.
     * @return The recipe data, or null if not found.
     */
    @GET("recipes/{slug}")
    suspend fun getRecipe(
        @Path("slug") slug: String
    ): MealieResponse<RecipeJson>

    /**
     * Creates a new recipe.
     *
     * @return Mealie response containing the slug of the created recipe.
     */
    @Headers("Content-Type: application/json")
    @POST("recipes")
    suspend fun createRecipe(
        @Body recipe: RecipeRequestJson,
    ): MealieResponse<String>

    /**
     * Updates an existing recipe.
     *
     * @param slug The slug or ID of the recipe to update.
     * @param recipe The updated recipe data.
     * @return The updated recipe.
     */
    @Headers("Content-Type: application/json")
    @PUT("recipes/{slug}")
    suspend fun updateRecipe(
        @Path("slug") slug: String,
        @Body recipe: RecipeRequestJson,
    ): MealieResponse<RecipeJson>

    /**
     * Bulk update recipes.
     */
    @Headers("Content-Type: application/json")
    @PUT("recipes")
    suspend fun updateRecipes(
        @Body recipes: List<RecipeRequestJson>,
    ): MealieResponse<List<RecipeJson>>

    /**
     * Bulk patch recipes.
     */
    @Headers("Content-Type: application/json")
    @PATCH("recipes")
    suspend fun patchRecipes(
        @Body recipes: List<RecipeRequestJson>,
    ): MealieResponse<List<RecipeJson>>

    /**
     * Partially updates an existing recipe.
     *
     * @param slug The slug or ID of the recipe to patch.
     * @param recipe The partial recipe data.
     * @return The updated recipe.
     */
    @Headers("Content-Type: application/json")
    @PATCH("recipes/{slug}")
    suspend fun patchRecipe(
        @Path("slug") slug: String,
        @Body recipe: RecipeRequestJson,
    ): MealieResponse<RecipeJson>

    /**
     * Duplicates a recipe.
     *
     * @param slug The slug or ID of the recipe to duplicate.
     * @return The slug of the newly created recipe.
     */
    @POST("recipes/{slug}/duplicate")
    suspend fun duplicateRecipe(
        @Path("slug") slug: String,
    ): MealieResponse<RecipeJson>

    /**
     * Deletes a recipe.
     *
     * @param slug The slug or ID of the recipe to delete.
     */
    @DELETE("recipes/{slug}")
    suspend fun deleteRecipe(
        @Path("slug") slug: String,
    ): MealieResponse<Unit>

    /**
     * Suggest recipes matching the given criteria.
     *
     * @param foods A list of foods to include in the suggestions. Defaults to `null`.
     * @param tools A list of tools to include in the suggestions. Defaults to `null`.
     * @param orderBy The field to order the suggestions by. Defaults to `null`.
     * @param orderByNullPosition The position of null values when ordering. Defaults to `null`.
     * @param orderDirection The direction of the ordering. Defaults to [OrderDirection.DESC].
     * @param paginationSeed A seed for pagination. Defaults to `null`.
     * @param limit The maximum number of suggestions to return. Defaults to `10`.
     * @param maxMissingFoods The maximum number of missing foods allowed in a suggestion. Defaults to `5`.
     * @param maxMissingTools The maximum number of missing tools allowed in a suggestion. Defaults to `5`.
     * @param includesFoodsOnHand Whether to include foods on hand in the suggestions. Defaults to `true`.
     * @param includesToolsOnHand Whether to include tools on hand in the suggestions. Defaults to `true`.
     *
     * @return A paged list of recipe suggestions.
     */
    @GET("recipes/suggestions")
    suspend fun suggestRecipes(
        @Query("foods")
        foods: List<String>? = null,
        @Query("tools")
        tools: List<String>? = null,
        @Query("orderBy")
        orderBy: String? = null,
        @Query("orderByNullPosition")
        orderByNullPosition: OrderByNullPosition? = null,
        @Query("orderDirection")
        orderDirection: OrderDirection = OrderDirection.DESC,
        @Query("paginationSeed")
        paginationSeed: String? = null,
        @Query("limit")
        limit: Int = 10,
        @Query("maxMissingFoods")
        maxMissingFoods: Int = 5,
        @Query("maxMissingTools")
        maxMissingTools: Int = 5,
        @Query("includeFoodsOnHand")
        includesFoodsOnHand: Boolean = true,
        @Query("includeToolsOnHand")
        includesToolsOnHand: Boolean = true,
    ): MealieResponse<PagedResponseJson<RecipeJson>>
}
