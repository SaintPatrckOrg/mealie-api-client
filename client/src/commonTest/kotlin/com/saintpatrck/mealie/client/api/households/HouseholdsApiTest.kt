package com.saintpatrck.mealie.client.api.households

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.households.model.CookbookJson
import com.saintpatrck.mealie.client.api.households.model.CookbookWithRecipesJson
import com.saintpatrck.mealie.client.api.households.model.CreateCookbookRequestJson
import com.saintpatrck.mealie.client.api.households.model.EventNotificationJson
import com.saintpatrck.mealie.client.api.households.model.UpdateCookbookRequestJson
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.model.getOrThrow
import com.saintpatrck.mealie.client.api.util.RECIPE_JSON
import com.saintpatrck.mealie.client.api.util.createMockRecipeJson
import io.ktor.client.engine.mock.toByteArray
import io.ktor.http.HttpMethod
import kotlinx.coroutines.test.runTest
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
    fun `getCookbook should construct request and deserialize response correctly`() = runTest {
        createTestMealieClient(
            responseJson = COOKBOOK_WITH_RECIPES_JSON,
            verifyRequest = { request ->
                assertEquals(request.method, HttpMethod.Get)
                assertEquals("/households/cookbooks/cookbookId", request.url.encodedPath)
            }
        )
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
    fun `updateCookbook should construct request and deserialize response correctly`() = runTest {
        createTestMealieClient(
            responseJson = COOKBOOK_JSON,
            verifyRequest = { request ->
                assertEquals(request.method, HttpMethod.Put)
                assertEquals("/households/cookbooks/cookbookId", request.url.encodedPath)
                assertEquals(
                    UPDATE_COOKBOOK_REQUEST_JSON,
                    request.body.toByteArray().decodeToString()
                )
            }
        )
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

    @Test
    fun `deleteCookbook should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = COOKBOOK_JSON)
            .householdsApi
            .deleteCookbook(
                cookbookId = "cookbookId"
            )
            .also { response ->
                assertEquals(
                    createMockCookbookJson(),
                    response.getOrThrow(),
                )
            }
    }

    @Test
    fun `getNotifications should deserialize correctly`() = runTest {
        createTestMealieClient(
            verifyRequest = { request ->
                assertEquals(HttpMethod.Get, request.method)
                assertEquals("/households/events/notifications", request.url.encodedPath)
                assertEquals("1", request.url.parameters["page"])
                assertEquals("10", request.url.parameters["perPage"])
            },
            responseJson = PAGED_EVENT_NOTIFICATIONS_RESPONSE_JSON,
        )
            .householdsApi
            .getNotifications(
                page = 1,
                perPage = 10,
            )
            .also { response ->
                assertEquals(
                    createMockPagedEventNotificationsResponse(),
                    response.getOrThrow(),
                )
            }
    }
}

private val PAGED_EVENT_NOTIFICATIONS_RESPONSE_JSON = """
{
  "page": 1,
  "per_page": 10,
  "total": 0,
  "total_pages": 0,
  "items": [
    {
      "id": "id",
      "name": "name",
      "enabled": true,
      "groupId": "groupId",
      "householdId": "householdId",
      "options": [
        {
          "testMessage": false,
          "webhookTask": false,
          "recipeCreated": false,
          "recipeUpdated": false,
          "recipeDeleted": false,
          "userSignup": false,
          "dataMigrations": false,
          "dataExport": false,
          "dataImport": false,
          "mealplanEntryCreated": false,
          "shoppingListCreated": false,
          "shoppingListUpdated": false,
          "shoppingListDeleted": false,
          "cookbookCreated": false,
          "cookbookUpdated": false,
          "cookbookDeleted": false,
          "tagCreated": false,
          "tagUpdated": false,
          "tagDeleted": false,
          "categoryCreated": false,
          "categoryUpdated": false,
          "categoryDeleted": false,
          "id": "id"
        }
      ]
    }
  ],
  "next": "next",
  "previous": "previous"
}
"""
    .trimIndent()
private val UPDATE_COOKBOOK_REQUEST_JSON = """
{"name":"name","description":"description","slug":"slug","position":1,"public":false,"queryFilterString":"queryFilterString"}
"""
    .trimIndent()
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
    $RECIPE_JSON  
  ]
}
"""
    .trimIndent()

private fun createMockPagedEventNotificationsResponse() = PagedResponseJson(
    page = 1,
    perPage = 10,
    totalPages = 0,
    total = 0,
    items = listOf(createMockEventNotificationJson()),
    next = "next",
    previous = "previous",
)

private fun createMockEventNotificationJson() = EventNotificationJson(
    id = "id",
    name = "name",
    enabled = true,
    groupId = "groupId",
    householdId = "householdId",
    options = listOf(createMockEventNotificationOptionJson())
)

private fun createMockEventNotificationOptionJson() =
    EventNotificationJson.EventNotificationOptionJson(
        testMessage = false,
        webhookTask = false,
        recipeCreated = false,
        recipeUpdated = false,
        recipeDeleted = false,
        userSignup = false,
        dataMigrations = false,
        dataExport = false,
        dataImport = false,
        mealplanEntryCreated = false,
        shoppingListCreated = false,
        shoppingListUpdated = false,
        shoppingListDeleted = false,
        cookbookCreated = false,
        cookbookUpdated = false,
        cookbookDeleted = false,
        tagCreated = false,
        tagUpdated = false,
        tagDeleted = false,
        categoryCreated = false,
        categoryUpdated = false,
        categoryDeleted = false,
        id = "id"
    )

private fun createMockPagedCookbooksResponseJson() = PagedResponseJson(
    page = 1,
    perPage = 10,
    totalPages = 0,
    total = 0,
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
