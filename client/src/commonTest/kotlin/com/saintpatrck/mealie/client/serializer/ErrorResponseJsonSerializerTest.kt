package com.saintpatrck.mealie.client.serializer

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.ErrorResponseJson
import com.saintpatrck.mealie.client.api.model.failureOrNull
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ErrorResponseJsonSerializerTest : BaseApiTest() {
    @Test
    fun `Unauthorized response should be deserialized correctly`() = runTest {
        createTestMealieClient(
            responseJson = UNAUTHORIZED_ERROR_RESPONSE,
            status = HttpStatusCode.Unauthorized,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
            .authApi
            .logout()
            .also { response ->
                assertEquals(
                    createMockUnauthorizedResponseJson(),
                    response.failureOrNull()?.error,
                )
            }
    }

    @Test
    fun `Validation response should be deserialized correctly`() = runTest {
        createTestMealieClient(
            responseJson = VALIDATION_ERROR_RESPONSE,
            status = HttpStatusCode.UnprocessableEntity,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
            .authApi
            .logout()
            .also { response ->
                assertEquals(
                    createMockValidationErrorResponseJson(),
                    response.failureOrNull()?.error,
                )
            }
    }

    @Test
    fun `Forbidden response should be deserialized correctly`() = runTest {
        createTestMealieClient(
            responseJson = FORBIDDEN_ERROR_RESPONSE,
            status = HttpStatusCode.Forbidden,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
            .authApi
            .logout()
            .also { response ->
                assertEquals(
                    createMockForbiddenResponseJson(),
                    response.failureOrNull()?.error,
                )
            }
    }
}

private val VALIDATION_ERROR_RESPONSE = """
{
  "detail": [
    {
      "loc": [
        "string"
      ],
      "msg": "string",
      "type": "string",
      "input": null,
      "ctx": null
    },
    {
      "loc": [
        "string"
      ],
      "msg": "string",
      "type": "string",
      "input": null,
      "ctx": {
        "key1": "string",
        "key2": 1,
        "key3": null
      }
    }
  ]
}
"""
    .trimIndent()

private val UNAUTHORIZED_ERROR_RESPONSE = """
{
    "detail": "string"
}
"""
    .trimIndent()


private val FORBIDDEN_ERROR_RESPONSE = """
{
    "detail": {
        "message": "string",
        "error": true,
        "exception": null
    }
}
"""
    .trimIndent()

private fun createMockValidationErrorResponseJson() = ErrorResponseJson.ValidationErrors(
    detail = listOf(
        ErrorResponseJson.ValidationErrors.ValidationError(
            location = listOf("string"),
            message = "string",
            type = "string",
            input = null,
            context = null,
        ),
        ErrorResponseJson.ValidationErrors.ValidationError(
            location = listOf("string"),
            message = "string",
            type = "string",
            input = null,
            context = mapOf(
                "key1" to "string",
                "key2" to "1",
                "key3" to null,
            ),
        ),
    )
)

private fun createMockUnauthorizedResponseJson() = ErrorResponseJson.Unauthorized(
    detail = "string",
)

private fun createMockForbiddenResponseJson() = ErrorResponseJson.Forbidden(
    detail = ErrorResponseJson.Forbidden.Detail(
        message = "string",
        error = true,
        exception = null,
    )
)
