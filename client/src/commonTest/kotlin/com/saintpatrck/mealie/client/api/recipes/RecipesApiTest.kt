package com.saintpatrck.mealie.client.api.recipes

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.getOrThrow
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromHtmlOrJsonRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkResponseJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlResponseJson
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RecipesApiTest : BaseApiTest() {

    @Test
    fun `testScrapeUrl should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = RECIPE_JSON)
            .recipesApi
            .testScrapeUrl(
                testScrapeUrlRequest = TestScrapeUrlRequestJson(
                    url = "mockUrl",
                    useOpenAi = false,
                )
            )
            .also { response ->
                assertEquals(
                    createMockRecipeJson(),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `createFromHtmlOrJson should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = CREATE_RECIPE_FROM_HTML_OR_JSON_RESPONSE)
            .recipesApi
            .createFromHtmlOrJson(
                request = CreateRecipeFromHtmlOrJsonRequestJson(
                    includeTags = false,
                    data = "data",
                )
            )
            .also {
                assertEquals(
                    CREATE_RECIPE_FROM_HTML_OR_JSON_RESPONSE,
                    it.getOrThrow(),
                )
            }
    }

    @Test
    fun `createRecipeFromUrl should deserialize correctly`() = runTest {
        createTestMealieClient(
            responseJson = "mockSlug",
        )
            .recipesApi
            .createRecipeFromUrl(
                request = CreateRecipeFromUrlRequestJson(
                    includeTags = false,
                    url = "mockUrl",
                )
            )
            .also { response ->
                assertEquals(
                    "mockSlug",
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `createRecipeFromUrlBulk should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = CREATE_RECIPE_FROM_URL_BULK_JSON_RESPONSE)
            .recipesApi
            .createFromUrlBulk(
                request = CreateRecipeFromUrlBulkRequestJson(
                    listOf(
                        CreateRecipeFromUrlBulkRequestJson.Import(
                            url = "mockUrl",
                            categories = emptyList(),
                            tags = emptyList(),
                        )
                    )
                )
            )
            .also { response ->
                assertEquals(
                    CreateRecipeFromUrlBulkResponseJson(
                        reportId = "f7f19343-4139-4e9f-a07e-a6fbfbe08b0f",
                    ),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `createRecipeFromZip should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .recipesApi
            .createFromZip(
                archive = MultiPartFormDataContent(
                    formData {
                        append("archive", byteArrayOf(0))
                    }
                )
            )
            .also { response ->
                assertEquals(
                    Unit,
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `createRecipeFromImage should deserialize correctly`() = runTest {
        val expectedLanguage = "en-US"
        createTestMealieClient(
            responseJson = "",
            verifyRequest = { request ->
                assertEquals(
                    expectedLanguage,
                    request.url.parameters["translateLanguage"]
                )
            }
        )
            .recipesApi
            .createFromImage(
                translateLanguage = expectedLanguage,
                image = MultiPartFormDataContent(
                    formData {
                        append("image", byteArrayOf(0))
                    }
                )
            )
            .also { response ->
                assertEquals(
                    Unit,
                    response.getOrThrow(),
                )
            }
    }
}

private const val RECIPE_JSON = """
{
    "@context": "https://schema.org/",
    "@type": "Recipe",
    "name": "BALTIMORE BLONDE FRIED CHICKEN",
    "image": [
        "https://images.ctfassets.net/8nq3bs98o7cv/6m5b87dnExetfdzn4dvPgX/8c694e17478abd939cc2219a312fd9a1/Baltimore_Blonde_Fried_Chicken"
    ],
    "description": "This recipe shows how Guinness can unlock unique flavours and new possibilities while cooking at home.",
    "prepTime": "PT2 hours 45 mins",
    "cookTime": "PT15 mins",
    "totalTime": "PT2 hours 45 minsPT15 mins",
    "recipeYield": "2-3",
    "author": "Guinness Rebuild",
    "recipeCategory": "Main",
    "recipeIngredient": [
        "BEER BRINE"
    ],
    "recipeInstructions": [
        {
            "@type": "HowToStep",
            "text": "BEER BRINE"
        }
    ]
}
"""
private const val CREATE_RECIPE_FROM_HTML_OR_JSON_RESPONSE = "mockResponse"
private const val CREATE_RECIPE_FROM_URL_BULK_JSON_RESPONSE = """
{
    "reportId": "f7f19343-4139-4e9f-a07e-a6fbfbe08b0f"
}
"""

private fun createMockRecipeJson() = TestScrapeUrlResponseJson(
    context = "https://schema.org/",
    type = "Recipe",
    name = "BALTIMORE BLONDE FRIED CHICKEN",
    image = listOf("https://images.ctfassets.net/8nq3bs98o7cv/6m5b87dnExetfdzn4dvPgX/8c694e17478abd939cc2219a312fd9a1/Baltimore_Blonde_Fried_Chicken"),
    description = "This recipe shows how Guinness can unlock unique flavours and new possibilities while cooking at home.",
    prepTime = "PT2 hours 45 mins",
    cookTime = "PT15 mins",
    totalTime = "PT2 hours 45 minsPT15 mins",
    recipeYield = "2-3",
    author = "Guinness Rebuild",
    recipeCategory = "Main",
    recipeIngredient = listOf(
        "BEER BRINE",
    ),
    recipeInstructions = listOf(
        TestScrapeUrlResponseJson.RecipeInstruction(
            type = "HowToStep",
            text = "BEER BRINE"
        ),
    ),
)
