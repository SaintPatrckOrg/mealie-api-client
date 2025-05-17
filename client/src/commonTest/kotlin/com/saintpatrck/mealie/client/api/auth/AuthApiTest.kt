package com.saintpatrck.mealie.client.api.auth

import com.saintpatrck.mealie.client.api.auth.model.LogoutResponseJson
import com.saintpatrck.mealie.client.api.auth.model.TokenResponseJson
import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.getOrNull
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AuthApiTest : BaseApiTest() {

    @Test
    fun `getToken should return success with data`() = runTest {
        createTestMealieClient(
            responseJson = TOKEN_RESPONSE_JSON,
        )
            .authApi
            .getToken(
                username = "username",
                password = "password",
                rememberMe = true,
            )
            .also { response ->
                assertEquals(
                    createMockTokenResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `refreshToken should return success with data`() = runTest {
        createTestMealieClient(
            responseJson = TOKEN_RESPONSE_JSON,
        )
            .authApi
            .refreshToken()
            .also { response ->
                assertEquals(
                    createMockTokenResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `logout should return success with data`() = runTest {
        createTestMealieClient(
            responseJson = LOGOUT_RESPONSE_JSON,
        )
            .authApi
            .logout()
            .also { response ->
                assertEquals(
                    createMockLogoutResponseJson(),
                    response.getOrNull(),
                )
            }
    }
}

private val TOKEN_RESPONSE_JSON = """
{
    "access_token": "string",
    "token_type": "string"
}
"""
    .trimIndent()
private val LOGOUT_RESPONSE_JSON = """
{
    "message": "string"
}
"""
    .trimIndent()

private fun createMockTokenResponseJson() = TokenResponseJson(
    accessToken = "string",
    tokenType = "string",
)

private fun createMockLogoutResponseJson() = LogoutResponseJson(
    message = "string",
)
