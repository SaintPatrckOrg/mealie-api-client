package com.saintpatrck.mealie.client.api.auth

import com.saintpatrck.mealie.client.api.auth.model.LogoutResponseJson
import com.saintpatrck.mealie.client.api.auth.model.TokenResponseJson
import com.saintpatrck.mealie.client.api.model.MealieResponse
import de.jensklingenberg.ktorfit.http.Field
import de.jensklingenberg.ktorfit.http.FormUrlEncoded
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST

/**
 * Represents the API for retrieving authentication tokens.
 */
interface AuthApi {

    /**
     * Retrieves authentication tokens.
     */
    @POST("auth/token")
    @FormUrlEncoded
    suspend fun getToken(
        @Field("username")
        username: String,

        @Field("password")
        password: String,

        @Field("remember_me")
        rememberMe: Boolean,
    ): MealieResponse<TokenResponseJson>

    /**
     * Refreshes the authentication tokens.
     */
    @GET("auth/refresh")
    suspend fun refreshToken(): MealieResponse<TokenResponseJson>

    /**
     * Logs out the user.
     */
    @POST("auth/logout")
    suspend fun logout(): MealieResponse<LogoutResponseJson>
}
