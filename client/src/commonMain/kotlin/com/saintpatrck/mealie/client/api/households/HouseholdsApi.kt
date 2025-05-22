package com.saintpatrck.mealie.client.api.households

import com.saintpatrck.mealie.client.api.households.model.CookbookJson
import com.saintpatrck.mealie.client.api.households.model.CookbookWithRecipesJson
import com.saintpatrck.mealie.client.api.households.model.CreateCookbookRequestJson
import com.saintpatrck.mealie.client.api.households.model.EventNotificationJson
import com.saintpatrck.mealie.client.api.households.model.UpdateCookbookRequestJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.OrderByNullPosition
import com.saintpatrck.mealie.client.api.model.OrderDirection
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.PUT
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

/**
 * API for managing household information.
 */
interface HouseholdsApi {

    /**
     * Retrieves a list of cookbooks.
     */
    @GET("households/cookbooks")
    suspend fun getCookbooks(): MealieResponse<PagedResponseJson<CookbookJson>>

    /**
     * Create a new cookbook.
     */
    @Headers("Content-Type: application/json")
    @POST("households/cookbooks")
    suspend fun createCookbook(
        @Body cookbook: CreateCookbookRequestJson,
    ): MealieResponse<CookbookJson>

    /**
     * Bulk update cookbooks.
     */
    @Headers("Content-Type: application/json")
    @PUT("households/cookbooks")
    suspend fun bulkUpdateCookbooks(
        @Body bulkUpdateRequest: List<CookbookJson>,
    ): MealieResponse<List<CookbookJson>>

    /**
     * Retrieves a cookbook by its ID.
     */
    @GET("households/cookbooks/{cookbookId}")
    suspend fun getCookbook(
        @Path("cookbookId")
        cookbookId: String,
    ): MealieResponse<CookbookWithRecipesJson>

    /**
     * Update a cookbook.
     */
    @Headers("Content-Type: application/json")
    @PUT("households/cookbooks/{cookbookId}")
    suspend fun updateCookbook(
        @Path("cookbookId")
        cookbookId: String,
        @Body cookbook: UpdateCookbookRequestJson,
    ): MealieResponse<CookbookJson>

    /**
     * Delete a cookbook.
     */
    @DELETE("households/cookbooks/{cookbookId}")
    suspend fun deleteCookbook(
        @Path("cookbookId")
        cookbookId: String,
    ): MealieResponse<CookbookJson>

    /**
     * Retrieves all event notifications.
     *
     * @param orderBy The field to order the results by
     * @param orderByNullPosition The position to order null values
     * @param orderDirection The direction to order the results
     * @param queryFilter A filter to apply to the results
     * @param paginationSeed A seed to use for pagination
     * @param page The page number to retrieve. Defaults to 1.
     * @param perPage The number of items to retrieve per page. Defaults to 50.
     */
    @GET("households/events/notifications")
    suspend fun getNotifications(
        @Query("orderBy")
        orderBy: String? = null,
        @Query("orderByNullPosition")
        orderByNullPosition: OrderByNullPosition? = null,
        @Query("orderDirection")
        orderDirection: OrderDirection? = null,
        @Query("queryFilter")
        queryFilter: String? = null,
        @Query("paginationSeed")
        paginationSeed: Int? = null,
        @Query("page")
        page: Int = 1,
        @Query("perPage")
        perPage: Int = 50,
    ): MealieResponse<PagedResponseJson<EventNotificationJson>>
}
