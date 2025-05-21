package com.saintpatrck.mealie.client.api.households

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.households.model.CookbookJson
import com.saintpatrck.mealie.client.api.households.model.CookbookWithRecipesJson
import com.saintpatrck.mealie.client.api.households.model.CreateCookbookRequestJson
import com.saintpatrck.mealie.client.api.households.model.UpdateCookbookRequestJson
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.model.getOrThrow
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals

class HouseholdsApiTest : BaseApiTest() {

    @Test
    fun `getCookbooks should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = GET_COOKBOOKS_RESPONSE_JSON)
            .householdsApi
            .getCookbooks()
            .also { response ->
                assertEquals(
                    createMockPagedCookbooksResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `createCookbook should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = COOKBOOK_JSON)
            .householdsApi
            .createCookbook(
                cookbook = CreateCookbookRequestJson(
                    name = "name",
                    description = "description",
                    slug = "slug",
                    position = 1,
                    public = false,
                )
            )
            .also { response ->
                assertEquals(
                    createMockCookbookJson(),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `bulkUpdateCookbooks should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = BULK_UPDATE_RESPONSE_JSON)
            .householdsApi
            .bulkUpdateCookbooks(
                bulkUpdateRequest = listOf(createMockCookbookJson())
            )
            .also { response ->
                assertEquals(
                    listOf(createMockCookbookJson()),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `getCookbook should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = COOKBOOK_WITH_RECIPES_JSON)
            .householdsApi
            .getCookbook(
                cookbookId = "cookbookId"
            )
            .also { response ->
                assertEquals(
                    createMockCookbookWithRecipesJson(),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `updateCookbook should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = COOKBOOK_JSON)
            .householdsApi
            .updateCookbook(
                cookbookId = "cookbookId",
                cookbook = UpdateCookbookRequestJson(
                    name = "name",
                    description = "description",
                    slug = "slug",
                    position = 1,
                    public = false,
                    queryFilterString = "queryFilterString",
                )
            )
            .also { response ->
                assertEquals(
                    createMockCookbookJson(),
                    response.getOrThrow(),
                )
            }
    }
}

private val GET_COOKBOOKS_RESPONSE_JSON = """
{
  "page": 1,
  "per_page": 10,
  "total": 0,
  "total_pages": 0,
  "items": [
    {
      "name": "name",
      "description": "description",
      "slug": "slug",
      "position": 1,
      "public": false,
      "queryFilterString": "queryFilterString",
      "groupId": "groupId",
      "householdId": "householdId",
      "id": "id",
      "queryFilter": {
        "parts": []
      }
    }
  ],
  "next": "next",
  "previous": "previous"
}
"""
    .trimIndent()
private val COOKBOOK_JSON = """
{
  "name": "name",
  "description": "description",
  "slug": "slug",
  "position": 1,
  "public": false,
  "queryFilterString": "queryFilterString",
  "groupId": "groupId",
  "householdId": "householdId",
  "id": "id",
  "queryFilter": {
    "parts": []
  }
}
"""
    .trimIndent()
private val BULK_UPDATE_RESPONSE_JSON = """
[
  {
    "name": "name",
    "description": "description",
    "slug": "slug",
    "position": 1,
    "public": false,
    "queryFilterString": "queryFilterString",
    "groupId": "groupId",
    "householdId": "householdId",
    "id": "id",
    "queryFilter": {
      "parts": []
    }
  }
]
"""
    .trimIndent()
private val COOKBOOK_WITH_RECIPES_JSON = """
{
  "name": "name",
  "description": "description",
  "slug": "slug",
  "position": 1,
  "public": false,
  "queryFilterString": "queryFilterString",
  "groupId": "groupId",
  "householdId": "householdId",
  "id": "id",
  "queryFilter": {
    "parts": []
  },
  "recipes": [
    {
      "id": "id",
      "userId": "userId",
      "householdId": "householdId",
      "groupId": "groupId",
      "name": "name",
      "slug": "slug",
      "image": null,
      "recipeServings": 0,
      "recipeYieldQuantity": 0,
      "recipeYield": "recipeYield",
      "totalTime": "totalTime",
      "prepTime": "prepTime",
      "cookTime": "cookTime",
      "performTime": "performTime",
      "description": "description",
      "recipeCategory": [
        {
          "id": "id",
          "name": "name",
          "slug": "slug"
        }
      ],
      "tags": [
        {
          "id": "id",
          "name": "name",
          "slug": "slug"
        }
      ],
      "tools": [
        {
          "id": "id",
          "name": "name",
          "slug": "slug",
          "householdsWithTool": [
            "householdsWithTool"
          ]
        }
      ],
      "rating": 0.0,
      "orgURL": "orgURL",
      "dateAdded": "2019-08-24",
      "dateUpdated": "2019-08-24T14:15:22Z",
      "createdAt": "2019-08-24T14:15:22Z",
      "updatedAt": "2019-08-24T14:15:22Z",
      "lastMade": "2019-08-24T14:15:22Z"
    }
  ]
}
"""
    .trimIndent()

private fun createMockPagedCookbooksResponseJson() = PagedResponseJson(
    page = 1,
    perPage = 10,
    totalPages = 0,
    items = listOf(createMockCookbookJson()),
    next = "next",
    previous = "previous"
)

private fun createMockCookbookJson() = CookbookJson(
    id = "id",
    name = "name",
    description = "description",
    slug = "slug",
    position = 1,
    public = false,
    queryFilterString = "queryFilterString",
    groupId = "groupId",
    householdId = "householdId",
)

private fun createMockCookbookWithRecipesJson() = CookbookWithRecipesJson(
    id = "id",
    name = "name",
    description = "description",
    slug = "slug",
    position = 1,
    public = false,
    queryFilterString = "queryFilterString",
    groupId = "groupId",
    householdId = "householdId",
    recipes = listOf(createMockRecipeJson())
)

private fun createMockRecipeJson() = CookbookWithRecipesJson.RecipeJson(
    id = "id",
    userId = "userId",
    householdId = "householdId",
    groupId = "groupId",
    name = "name",
    slug = "slug",
    image = null,
    recipeServings = 0.0,
    recipeYieldQuantity = 0.0,
    recipeYield = "recipeYield",
    totalTime = "totalTime",
    prepTime = "prepTime",
    cookTime = "cookTime",
    performTime = "performTime",
    description = "description",
    recipeCategory = listOf(createMockRecipeCategory()),
    tags = listOf(createMockRecipeTag()),
    tools = listOf(createMockRecipeTool()),
    rating = 0.0,
    orgUrl = "orgURL",
    dateAdded = "2019-08-24",
    dateUpdated = Instant.parse("2019-08-24T14:15:22Z"),
    createdAt = Instant.parse("2019-08-24T14:15:22Z"),
    updatedAt = Instant.parse("2019-08-24T14:15:22Z"),
    lastMade = Instant.parse("2019-08-24T14:15:22Z"),
)

private fun createMockRecipeCategory() = CookbookWithRecipesJson.RecipeJson.RecipeCategory(
    id = "id",
    name = "name",
    slug = "slug",
)

private fun createMockRecipeTag() = CookbookWithRecipesJson.RecipeJson.RecipeTag(
    id = "id",
    name = "name",
    slug = "slug",
)

private fun createMockRecipeTool() = CookbookWithRecipesJson.RecipeJson.RecipeTool(
    id = "id",
    name = "name",
    slug = "slug",
    householdsWithTool = listOf("householdsWithTool")
)
