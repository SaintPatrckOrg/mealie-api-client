package com.saintpatrck.mealie.client.api.admin

import com.saintpatrck.mealie.client.api.admin.model.UserResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.model.OrderByNullPosition
import com.saintpatrck.mealie.client.api.model.OrderDirection
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

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
}
