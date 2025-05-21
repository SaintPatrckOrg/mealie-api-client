import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.HttpRequestData
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf

/**
 * Creates a mock engine for testing purposes.
 */
fun createMockEngine(
    response: String,
    status: HttpStatusCode = HttpStatusCode.OK,
    headers: Headers = headersOf(HttpHeaders.ContentType, "application/json"),
    verifyRequest: suspend (request: HttpRequestData) -> Unit = {},
): MockEngine {
    return MockEngine { request ->
        verifyRequest(request)
        respond(
            content = response,
            status = status,
            headers = headers
        )
    }
}
