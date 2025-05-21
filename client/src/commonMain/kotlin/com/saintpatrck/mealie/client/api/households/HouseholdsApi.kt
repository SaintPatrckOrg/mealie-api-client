package com.saintpatrck.mealie.client.api.households

import com.saintpatrck.mealie.client.api.households.model.CookbooksResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import de.jensklingenberg.ktorfit.http.GET

/**
 * API for managing household information.
 */
interface HouseholdsApi {

    /**
     * Retrieves a list of cookbooks.
     */
    @GET("households/cookbooks")
    suspend fun getCookbooks(): MealieResponse<PagedResponseJson<CookbooksResponseJson>>
}
