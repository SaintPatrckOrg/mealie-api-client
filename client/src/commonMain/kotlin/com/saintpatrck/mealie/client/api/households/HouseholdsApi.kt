package com.saintpatrck.mealie.client.api.households

import com.saintpatrck.mealie.client.api.households.model.CookbookJson
import com.saintpatrck.mealie.client.api.households.model.CookbookWithRecipesJson
import com.saintpatrck.mealie.client.api.households.model.CreateCookbookRequestJson
import com.saintpatrck.mealie.client.api.households.model.UpdateCookbookRequestJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.PUT
import de.jensklingenberg.ktorfit.http.Path

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
}
