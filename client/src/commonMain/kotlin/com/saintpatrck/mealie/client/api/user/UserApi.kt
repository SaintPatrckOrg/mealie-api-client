package com.saintpatrck.mealie.client.api.user

import com.saintpatrck.mealie.client.api.model.ErrorResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.OrderByNullPosition
import com.saintpatrck.mealie.client.api.model.OrderDirection
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.Rating
import com.saintpatrck.mealie.client.api.user.model.CreateApiTokenRequestJson
import com.saintpatrck.mealie.client.api.user.model.CreateApiTokenResponseJson
import com.saintpatrck.mealie.client.api.user.model.CreateUserRequestJson
import com.saintpatrck.mealie.client.api.user.model.DeleteTokenResponseJson
import com.saintpatrck.mealie.client.api.user.model.FavoritesResponseJson
import com.saintpatrck.mealie.client.api.user.model.ForgotPasswordRequestJson
import com.saintpatrck.mealie.client.api.user.model.RatingsResponseJson
import com.saintpatrck.mealie.client.api.user.model.RegisterUserRequestJson
import com.saintpatrck.mealie.client.api.user.model.RegisterUserResponseJson
import com.saintpatrck.mealie.client.api.user.model.ResetPasswordRequestJson
import com.saintpatrck.mealie.client.api.user.model.SelfResponseJson
import com.saintpatrck.mealie.client.api.user.model.SetRatingRequestJson
import com.saintpatrck.mealie.client.api.user.model.UpdatePasswordRequestJson
import com.saintpatrck.mealie.client.api.user.model.UpdateUserRequestJson
import com.saintpatrck.mealie.client.api.user.model.UserResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.PUT
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

/**
 * Represents the API for managing user information.
 */
interface UserApi {
    /**
     * Registers a new user.
     */
    @Headers("Content-Type: application/json")
    @POST("users/register")
    suspend fun registerUser(
        @Body user: RegisterUserRequestJson,
    ): MealieResponse<RegisterUserResponseJson>

    /**
     * Retrieves the current user's information.
     */
    @GET("users/self")
    suspend fun self(): MealieResponse<SelfResponseJson>

    /**
     * Retrieves the current user's rated recipes.
     */
    @GET("users/self/ratings")
    suspend fun ratings(): MealieResponse<RatingsResponseJson>

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
    suspend fun favorites(): MealieResponse<FavoritesResponseJson>

    /**
     * Changes the current user's password.
     */
    @Headers("Content-Type: application/json")
    @PUT("users/self/password")
    suspend fun updatePassword(
        @Body
        updatePasswordRequestJson: UpdatePasswordRequestJson,
    ): MealieResponse<Unit>

    /**
     * Updates the current user's information.
     */
    @Headers("Content-Type: application/json")
    @PUT("users/{userId}")
    suspend fun updateUser(
        @Path("userId")
        userId: String,
        @Body
        updateUserRequestJson: UpdateUserRequestJson,
    ): MealieResponse<Unit>

    /**
     * Retrieves a user with the given [userId].
     *
     * @param userId The ID of the user to retrieve.
     */
    @GET("users/{userId}")
    suspend fun getUser(
        @Path("userId")
        userId: String,
    ): MealieResponse<UserResponseJson>

    /**
     * Deletes the user with the given [userId].
     */
    @DELETE("users/{userId}")
    suspend fun deleteUser(
        @Path("userId")
        userId: String,
    ): MealieResponse<Unit>

    /**
     * Retrieves all users, from all groups. Results are paginated.
     */
    @GET("users")
    suspend fun getAllUsers(
        @Query("orderBy")
        orderBy: String? = null,
        @Query("orderByNullPosition")
        orderByNullPosition: OrderByNullPosition? = null,
        @Query("orderDirection")
        orderDirection: OrderDirection = OrderDirection.DESC,
        @Query("queryFilter")
        queryFilter: String? = null,
        @Query("page")
        page: Int = 1,
        @Query("pageSize")
        perPage: Int = 50,
    ): MealieResponse<PagedResponseJson<UserResponseJson>>

    /**
     * Creates a new user.
     */
    @Headers("Content-Type: application/json")
    @POST("users")
    suspend fun createUser(
        @Body user: CreateUserRequestJson,
    ): MealieResponse<UserResponseJson>

    /**
     * Initiates a password reset by sending a link to a user's email.
     */
    @Headers("Content-Type: application/json")
    @POST("users/forgot-password")
    suspend fun forgotPassword(
        @Body
        forgotPasswordRequest: ForgotPasswordRequestJson,
    ): MealieResponse<Unit>

    /**
     * Resets a password.
     */
    @Headers("Content-Type: application/json")
    @POST("users/reset-password")
    suspend fun resetPassword(
        @Body
        resetPasswordRequest: ResetPasswordRequestJson,
    ): MealieResponse<Unit>

    /**
     * Creates a new API token for the current user.
     */
    @Headers("Content-Type: application/json")
    @POST("users/api-tokens")
    suspend fun createApiToken(
        @Body
        createApiTokenRequestJson: CreateApiTokenRequestJson,
    ): MealieResponse<CreateApiTokenResponseJson>

    /**
     * Deletes an API token for the current user.
     */
    @DELETE("users/api-tokens/{tokenId}")
    suspend fun deleteApiToken(
        @Path("tokenId")
        token: Int,
    ): MealieResponse<DeleteTokenResponseJson>

    /**
     * Get ratings for the user with the given [userId].
     */
    @GET("users/{userId}/ratings")
    suspend fun getRatingsForUser(
        @Path("userId")
        userId: String,
    ): MealieResponse<RatingsResponseJson>

    /**
     * Get favorites for the user with the given [userId].
     */
    @GET("users/{userId}/favorites")
    suspend fun getFavoritesForUser(
        @Path("userId")
        userId: String,
    ): MealieResponse<FavoritesResponseJson>

    /**
     * Set the user's rating for a recipe.
     *
     * @param userId The ID of the user.
     * @param recipeId The ID of the recipe.
     * @param rating The rating to set.
     */
    @Headers("Content-Type: application/json")
    @POST("users/{userId}/ratings/{recipeId}")
    suspend fun setRating(
        @Path("userId")
        userId: String,
        @Path("recipeId")
        recipeId: String,
        @Body
        rating: SetRatingRequestJson,
    ): MealieResponse<Unit>

    /**
     * Add a recipe to the user's favorites.
     *
     * @param userId The ID of the user.
     * @param recipeId The ID of the recipe.
     */
    @POST("users/{userId}/favorites/{recipeId}")
    suspend fun addFavorite(
        @Path("userId")
        userId: String,
        @Path("recipeId")
        recipeId: String,
    ): MealieResponse<Unit>
}
