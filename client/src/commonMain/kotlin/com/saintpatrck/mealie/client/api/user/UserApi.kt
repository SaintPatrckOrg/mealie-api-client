package com.saintpatrck.mealie.client.api.user

import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.user.model.SelfRatingsResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfResponseJson
import de.jensklingenberg.ktorfit.http.GET

/**
 * Represents the API for managing user information.
 */
interface UserApi {

    /**
     * Gets the current user's information.
     */
    @GET("users/self")
    suspend fun self(): MealieResponse<SelfResponseJson>

    /**
     * Retrieves the current user's rated recipes.
     */
    @GET("users/self/ratings")
    suspend fun ratings(): MealieResponse<SelfRatingsResponseJson>
}
