package com.saintpatrck.mealie.client.api.user

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.MealieToken
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.registration.model.MealieAuthMethod
import com.saintpatrck.mealie.client.api.user.model.SelfResponseJson
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UserApiTest : BaseApiTest() {

    @Test
    fun `self should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = SELF_RESPONSE_JSON)
            .userApi
            .self()
            .also { response ->
                assertEquals(
                    createMockSelfResponseJson(),
                    response.getOrNull(),
                )
            }
    }
}

private const val SELF_RESPONSE_JSON = """
{
  "username": "username",
  "email": "test@email.com",
  "fullName": "fullName",
  "group": "group",
  "household": "household",
  "groupId": "groupId",
  "advanced": false,
  "canManageHousehold": false,
  "id": "id",
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

private fun createMockSelfResponseJson() = SelfResponseJson(
    id = "id",
    username = "username",
    fullName = "fullName",
    email = "test@email.com",
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
