import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
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
): MockEngine {
    return MockEngine { request ->
        respond(
            content = response,
            status = status,
            headers = headers
        )
    }
}