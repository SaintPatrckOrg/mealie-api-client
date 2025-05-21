package com.saintpatrck.mealie.client.api.households

import com.saintpatrck.mealie.client.api.households.model.CookbooksResponseJson
import com.saintpatrck.mealie.client.api.households.model.CreateCookbookRequestJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST

/**
 * API for managing household information.
 */
interface HouseholdsApi {

    /**
     * Retrieves a list of cookbooks.
     */
    @GET("households/cookbooks")
    suspend fun getCookbooks(): MealieResponse<PagedResponseJson<CookbooksResponseJson>>

    /**
     * Create a new cookbook.
     */
    @Headers("Content-Type: application/json")
    @POST("households/cookbooks")
    suspend fun createCookbook(
        @Body cookbook: CreateCookbookRequestJson,
    ): MealieResponse<CookbooksResponseJson>
}
