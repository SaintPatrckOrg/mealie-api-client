package com.saintpatrck.mealie.client.api.user

import com.saintpatrck.mealie.client.api.model.ErrorResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.Rating
import com.saintpatrck.mealie.client.api.user.model.SelfFavoritesResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfRatingsResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfResponseJson
import com.saintpatrck.mealie.client.api.user.model.UpdatePasswordRequestJson
import com.saintpatrck.mealie.client.api.user.model.UpdateUserRequestJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.PUT
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
    @GET("users/self/ratings/{recipeId}")
    suspend fun ratingForRecipe(
        @Path("recipeId")
        recipeId: String,
    ): MealieResponse<Rating>

    /**
     * Retrieves the current user's favorite recipes.
     */
    @GET("users/self/favorites")
    suspend fun favorites(): MealieResponse<SelfFavoritesResponseJson>

    /**
     * Changes the current user's password.
     */
    @Headers("Content-Type: application/json")
    @PUT("users/self/password")
    suspend fun updatePassword(
        @Body
        updatePasswordRequestJson: UpdatePasswordRequestJson,
    ): MealieResponse<Unit>

    @Headers("Content-Type: application/json")
    @PUT("users/{userId}")
    suspend fun updateUser(
        @Path("userId")
        userId: String,
        @Body
        updateUserRequestJson: UpdateUserRequestJson,
    ): MealieResponse<Unit>
}
