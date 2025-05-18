package com.saintpatrck.mealie.client.api.password

import com.saintpatrck.mealie.client.api.model.MealieResponse
import com.saintpatrck.mealie.client.api.password.model.ForgotPasswordRequestJson
import com.saintpatrck.mealie.client.api.password.model.ResetPasswordRequestJson
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST

/**
 * Represents the API for resetting a password.
 */
interface PasswordApi {

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
}
