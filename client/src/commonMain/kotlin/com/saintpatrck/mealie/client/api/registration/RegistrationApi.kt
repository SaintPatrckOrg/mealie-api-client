package com.saintpatrck.mealie.client.api.registration

import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.registration.model.RegisterUserRequestJson
import com.saintpatrck.mealie.client.api.registration.model.RegisterUserResponseJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST

/**
 * Represents the API for registering new users.
 */
interface RegistrationApi {

    /**
     * Registers a new user.
     */
    @Headers("Content-Type: application/json")
    @POST("users/register")
    suspend fun registerUser(
        @Body user: RegisterUserRequestJson,
    ): MealieResponse<RegisterUserResponseJson>
}
