package com.saintpatrck.mealie.client.api.recipes

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.MultiPurposeLabelSummaryJson
import com.saintpatrck.mealie.client.api.model.OrderByNullPosition
import com.saintpatrck.mealie.client.api.model.OrderDirection
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.getOrThrow
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromHtmlOrJsonRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlBulkResponseJson
import com.saintpatrck.mealie.client.api.recipes.model.CreateRecipeFromUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.RecipeIngredientJson
import com.saintpatrck.mealie.client.api.recipes.model.RecipeInstructionJson
import com.saintpatrck.mealie.client.api.recipes.model.RecipeNutritionJson
import com.saintpatrck.mealie.client.api.recipes.model.RecipeRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.RecipeSettingsJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlRequestJson
import com.saintpatrck.mealie.client.api.recipes.model.TestScrapeUrlResponseJson
import com.saintpatrck.mealie.client.api.util.RECIPE_JSON
import com.saintpatrck.mealie.client.api.util.RECIPE_LIST_JSON
import com.saintpatrck.mealie.client.api.util.createMockRecipeJson
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals

class RecipesApiTest : BaseApiTest() {

    @Test
    fun `testScrapeUrl should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = TEST_SCRAPE_URL_RESPONSE_JSON)
            .recipesApi
            .testScrapeUrl(
                testScrapeUrlRequest = TestScrapeUrlRequestJson(
                    url = "mockUrl",
                    useOpenAi = false,
                )
            )
            .also { response ->
                assertEquals(
                    createMockTestScrapeUrlResponseJson(),
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

    @Test
    fun `getRecipes should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = PAGED_RECIPE_RESPONSE_JSON)
            .recipesApi
            .getRecipes()
            .also { response ->
                assertEquals(
                    createMockPagedRecipeResponseJson(),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `createRecipe should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "mockSlug")
            .recipesApi
            .createRecipe(
                recipe = createMockRecipeRequestJson(),
            )
            .also { response ->
                assertEquals(
                    "mockSlug",
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `updateRecipes should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = RECIPE_LIST_JSON)
            .recipesApi
            .updateRecipes(
                recipes = listOf(createMockRecipeRequestJson())
            )
            .also { response ->
                assertEquals(
                    listOf(createMockRecipeJson()),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `patchRecipes should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = RECIPE_LIST_JSON)
            .recipesApi
            .patchRecipes(
                recipes = listOf(createMockRecipeRequestJson())
            )
            .also { response ->
                assertEquals(
                    listOf(createMockRecipeJson()),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `suggestRecipes should construct url and deserialize response correctly`() = runTest {
        createTestMealieClient(responseJson = PAGED_RECIPE_RESPONSE_JSON) {
            assertEquals(
                "http://localhost:9925/recipes/suggestions?foods=mockFood1&foods=mockFood2&tools=mockTool1&tools=mockTool2&orderBy=mockOrderBy&orderByNullPosition=FIRST&orderDirection=ASC&paginationSeed=mockPaginationSeed&limit=10&maxMissingFoods=5&maxMissingTools=5&includeFoodsOnHand=true&includeToolsOnHand=true",
                it.url.toString()
            )
        }
            .recipesApi
            .suggestRecipes(
                foods = listOf("mockFood1", "mockFood2"),
                tools = listOf("mockTool1", "mockTool2"),
                orderBy = "mockOrderBy",
                orderDirection = OrderDirection.ASC,
                orderByNullPosition = OrderByNullPosition.FIRST,
                paginationSeed = "mockPaginationSeed",
                limit = 10,
                maxMissingFoods = 5,
                maxMissingTools = 5,
                includesFoodsOnHand = true,
                includesToolsOnHand = true,
            )
            .also {
                assertEquals(
                    createMockPagedRecipeResponseJson(),
                    it.getOrThrow(),
                )
            }
    }
}

private val TEST_SCRAPE_URL_RESPONSE_JSON = """
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
    .trimIndent()
private const val CREATE_RECIPE_FROM_HTML_OR_JSON_RESPONSE = "mockResponse"
private val CREATE_RECIPE_FROM_URL_BULK_JSON_RESPONSE = """
{
    "reportId": "f7f19343-4139-4e9f-a07e-a6fbfbe08b0f"
}
"""
    .trimIndent()
private val PAGED_RECIPE_RESPONSE_JSON = """
{
    "page": 1,
    "per_page": 10,
    "total": 6,
    "total_pages": 0,
    "items": [
        $RECIPE_JSON
    ],
    "next": "next",
    "previous": "previous"
}
"""
    .trimIndent()

private fun createMockTestScrapeUrlResponseJson() = TestScrapeUrlResponseJson(
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
        TestScrapeUrlResponseJson.InstructionJson(
            type = "HowToStep",
            text = "BEER BRINE"
        ),
    ),
)

private fun createMockPagedRecipeResponseJson() = PagedResponseJson(
    page = 1,
    perPage = 10,
    totalPages = 0,
    total = 6,
    items = listOf(createMockRecipeJson()),
    next = "next",
    previous = "previous",
)

private fun createMockRecipeRequestJson() = RecipeRequestJson(
    id = "8da7c6cc-d122-4c46-b629-88ce745dba36",
    userId = "2d8b754b-7e78-4415-a3cb-2e72678dc2ed",
    householdId = "56ebaa77-e16e-4337-81d7-643798394270",
    groupId = "09ef762a-c811-45a9-8db8-cb2037269a10",
    name = "TEST TEST TEST CHICKEN & APPLE BANGERS & MASH TEST TEST TEST",
    slug = "test-test-test-chicken-apple-bangers-mash-test-test-test",
    image = null,
    recipeServings = 0.0,
    recipeYieldQuantity = 0.0,
    recipeYield = null,
    totalTime = null,
    prepTime = null,
    cookTime = null,
    performTime = null,
    description = "",
    recipeCategory = emptyList(),
    tags = emptyList(),
    tools = emptyList(),
    rating = null,
    orgUrl = null,
    dateAdded = "2025-06-07",
    dateUpdated = Instant.parse("2025-06-07T03:30:46.513510Z"),
    createdAt = Instant.parse("2025-06-07T03:30:46.513510Z"),
    updatedAt = Instant.parse("2025-06-07T03:30:46.513510Z"),
    lastMade = null,
    recipeIngredients = listOf(
        createMockRecipeIngredient(number = 1),
    ),
    recipeInstructions = listOf(
        createMockRecipeInstruction(number = 1),
    ),
    nutrition = createMockRecipeNutrition(number = 1),
    settings = createMockRecipeSettings(),
    assets = emptyList(),
    notes = emptyList(),
    extras = null,
    comments = emptyList(),
)

private fun createMockRecipeIngredient(
    number: Int,
): RecipeIngredientJson = RecipeIngredientJson(
    quantity = number.toDouble(),
    unit = RecipeIngredientJson.IngredientUnitJson(
        id = "mockId-$number",
        name = "mockName-$number",
        pluralName = "mockPluralName-$number",
        description = "mockDescription-$number",
        extras = "mockExtras-$number",
        fraction = true,
        abbreviation = "mockAbbreviation-$number",
        pluralAbbreviation = "mockPluralAbbreviation-$number",
        useAbbreviation = false,
        aliases = listOf("mockAlias-$number"),
        createdAt = Instant.parse("2025-06-07T03:30:46.513510Z"),
        updatedAt = Instant.parse("2025-06-07T03:30:46.513510Z"),
    ),
    food = RecipeIngredientJson.IngredientFoodJson(
        id = "mockId-$number",
        name = "mockName-$number",
        pluralName = "mockPluralName-$number",
        description = "mockDescription-$number",
        extras = "mockExtras-$number",
        labelId = "mockLabelId-$number",
        aliases = listOf("mockAlias-$number"),
        householdsWithIngredientFood = listOf("mockHouseholdWithIngredientFood-$number"),
        label = MultiPurposeLabelSummaryJson(
            id = "mockId-$number",
            name = "mockName-$number",
            color = "mockColor-$number",
            groupId = "mockGroupId-$number",
        ),
    ),
    note = "mockNote-$number",
    isFood = true,
    disableAmount = true,
    display = "mockDisplay-$number",
    title = "mockTitle-$number",
    originalText = "mockOriginalText-$number",
    referenceId = "mockReferenceId-$number",
)

private fun createMockRecipeInstruction(
    number: Int,
): RecipeInstructionJson = RecipeInstructionJson(
    id = "mockId-$number",
    title = "mockTitle-$number",
    text = "mockText-$number",
    ingredientReferences = listOf("mockIngredientReferences-$number"),
)

private fun createMockRecipeNutrition(
    number: Int? = null,
): RecipeNutritionJson = RecipeNutritionJson(
    calories = "mockCalories-$number",
    carbohydrateContent = "mockCarbohydrateContent-$number",
    cholesterolContent = "mockCholesterolContent-$number",
    fatContent = "mockFatContent-$number",
    fiberContent = "mockFiberContent-$number",
    proteinContent = "mockProteinContent-$number",
    saturatedFatContent = "mockSaturatedFatContent-$number",
    sodiumContent = "mockSodiumContent-$number",
    sugarContent = "mockSugarContent-$number",
    unsaturatedFatContent = "mockUnsaturatedFatContent-$number"
)

private fun createMockRecipeSettings(): RecipeSettingsJson = RecipeSettingsJson()
