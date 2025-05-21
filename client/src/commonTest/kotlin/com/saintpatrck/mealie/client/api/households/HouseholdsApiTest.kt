package com.saintpatrck.mealie.client.api.households

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.households.model.CookbooksResponseJson
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.getOrNull
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

private fun createMockPagedCookbooksResponseJson() = PagedResponseJson(
    page = 1,
    perPage = 10,
    totalPages = 0,
    items = listOf(createMockCookbookResponseJson()),
    next = "next",
    previous = "previous"
)

private fun createMockCookbookResponseJson() = CookbooksResponseJson(
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
