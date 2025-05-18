package com.saintpatrck.mealie.client.api.password

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.password.model.ForgotPasswordRequestJson
import com.saintpatrck.mealie.client.api.password.model.ResetPasswordRequestJson
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PasswordApiTest : BaseApiTest() {

    @Test
    fun `forgotPassword should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .passwordApi
            .forgotPassword(
                forgotPasswordRequest = ForgotPasswordRequestJson(
                    email = "email",
                )
            )
            .also {
                assertEquals(
                    Unit,
                    it.getOrNull(),
                )
            }
    }

    @Test
    fun `resetPassword should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .passwordApi
            .resetPassword(
                resetPasswordRequest = ResetPasswordRequestJson(
                    token = "token",
                    email = "email",
                    password = "password",
                    passwordConfirm = "passwordConfirm",
                )
            )
            .also {
                assertEquals(
                    Unit,
                    it.getOrNull(),
                )
            }
    }
}
