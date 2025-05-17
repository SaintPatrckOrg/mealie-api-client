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
    fun `failure with short error should be deserialized correctly`() = runTest {
        createTestMealieClient(
            responseJson = SHORT_ERROR_RESPONSE,
            status = HttpStatusCode.BadRequest,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
            .authApi
            .logout()
            .also { response ->
                assertEquals(
                    createMockShortErrorResponseJson(),
                    response.failureOrNull()?.error,
                )
            }
    }

    @Test
    fun `failure with detailed error should be deserialized correctly`() = runTest {
        createTestMealieClient(
            responseJson = ERROR_RESPONSE,
            status = HttpStatusCode.BadRequest,
            headers = headersOf(HttpHeaders.ContentType, "application/json"),
        )
            .authApi
            .logout()
            .also { response ->
                assertEquals(
                    createMockDetailedErrorResponseJson(),
                    response.failureOrNull()?.error,
                )
            }
    }
}

private val SHORT_ERROR_RESPONSE = """
{
    "detail": "string"
}
"""
    .trimIndent()

private val ERROR_RESPONSE = """
{
  "detail": [
    {
      "loc": [
        "string"
      ],
      "msg": "string",
      "type": "string"
    }
  ]
}
"""
    .trimIndent()

private fun createMockDetailedErrorResponseJson() = ErrorResponseJson.DetailedError(
    detail = listOf(
        ErrorResponseJson.DetailedError.ErrorDetail(
            location = listOf("string"),
            message = "string",
            type = "string",
        )
    )
)

private fun createMockShortErrorResponseJson() = ErrorResponseJson.ShortError(
    detail = "string",
)
