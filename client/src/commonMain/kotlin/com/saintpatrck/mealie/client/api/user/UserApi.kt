package com.saintpatrck.mealie.client.api.user

import com.saintpatrck.mealie.client.api.model.ErrorResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.Rating
import com.saintpatrck.mealie.client.api.user.model.SelfFavoritesResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfRatingsResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfResponseJson
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

/**
 * Represents the API for managing user information.
 */
interface UserApi {

    /**
     * Retrieves the current user's information.
     */
    @GET("users/self")
    suspend fun self(): MealieResponse<SelfResponseJson>

    /**
     * Retrieves the current user's rated recipes.
     */
    @GET("users/self/ratings")
    suspend fun ratings(): MealieResponse<SelfRatingsResponseJson>

    /**
     * Retrieves the current user's rating for a specific recipe.
     *
     * If the user has not rated the recipe, an [ErrorResponseJson] will be returned.
     *
     * @param recipeId The ID of the recipe.
     */
    @GET("users/rating/{recipeId}")
    suspend fun ratingForRecipe(
        @Path("recipeId")
        recipeId: String,
    ): MealieResponse<Rating>

    /**
     * Retrieves the current user's favorite recipes.
     */
    @GET("users/self/favorites")
    suspend fun favorites(): MealieResponse<SelfFavoritesResponseJson>
}
