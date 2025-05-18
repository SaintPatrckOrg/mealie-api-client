package com.saintpatrck.mealie.client.api.admin

import com.saintpatrck.mealie.client.api.admin.model.UserResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

/**
 * Represents the API for administering users.
 */
interface AdminApi {

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
}
