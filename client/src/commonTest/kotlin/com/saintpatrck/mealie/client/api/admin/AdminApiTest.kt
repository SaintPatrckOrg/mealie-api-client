package com.saintpatrck.mealie.client.api.admin

import com.saintpatrck.mealie.client.api.admin.model.UserResponseJson
import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.MealieToken
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.registration.model.MealieAuthMethod
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AdminApiTest : BaseApiTest() {

    @Test
    fun `getUser should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = GET_USER_RESPONSE_JSON)
            .adminApi
            .getUser("userId")
            .also { response ->
                assertEquals(
                    createMockUserResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `deleteUser should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .adminApi
            .deleteUser("userId")
            .also { response ->
                assertEquals(
                    Unit,
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `getAllUsers should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = GET_ALL_USERS_RESPONSE_JSON)
            .adminApi
            .getAllUsers()
            .also {
                assertEquals(
                    createMockPagedUserResponseJson(),
                    it.getOrNull(),
                )
            }
    }
}

private val GET_USER_RESPONSE_JSON = """
{
  "id": "id",
  "username": "username",
  "email": "email",
  "fullName": "fullName",
  "group": "group",
  "household": "household",
  "groupId": "groupId",
  "advanced": false,
  "canManageHousehold": false,
  "authMethod": "MEALIE",
  "admin": false,
  "canInvite": false,
  "canManage": false,
  "canOrganize": false,
  "groupSlug": "groupSlug",
  "householdId": "householdId",
  "householdSlug": "householdSlug",
  "tokens": [
    {
      "id": "id",
      "name": "name",
      "createdAt": "createdAt"
    }
  ],
  "cacheKey": "cacheKey"
}    
"""
    .trimIndent()

private val GET_ALL_USERS_RESPONSE_JSON = """
{
  "page": 1,
  "per_page": 10,
  "total": 0,
  "total_pages": 0,
  "items": [
    $GET_USER_RESPONSE_JSON
  ],
  "next": "string",
  "previous": "string"
}
"""
    .trimIndent()


private fun createMockUserResponseJson() = UserResponseJson(
    id = "id",
    username = "username",
    fullName = "fullName",
    email = "email",
    authMethod = MealieAuthMethod.MEALIE,
    admin = false,
    group = "group",
    household = "household",
    advanced = false,
    canInvite = false,
    canManage = false,
    canManageHousehold = false,
    canOrganize = false,
    groupId = "groupId",
    groupSlug = "groupSlug",
    householdId = "householdId",
    householdSlug = "householdSlug",
    tokens = listOf(
        MealieToken(
            id = "id",
            name = "name",
            createdAt = "createdAt",
        )
    ),
    cacheKey = "cacheKey",
)

private fun createMockPagedUserResponseJson(): PagedResponseJson<UserResponseJson> =
    PagedResponseJson(
        page = 1,
        perPage = 10,
        totalPages = 0,
        items = listOf(createMockUserResponseJson()),
        next = "string",
        previous = "string",
    )
