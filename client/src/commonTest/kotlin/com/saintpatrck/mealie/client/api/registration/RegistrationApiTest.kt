package com.saintpatrck.mealie.client.api.registration

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.registration.model.MealieAuthMethod
import com.saintpatrck.mealie.client.api.registration.model.RegisterUserRequestJson
import com.saintpatrck.mealie.client.api.registration.model.RegisterUserResponseJson
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RegistrationApiTest : BaseApiTest() {

    @Test
    fun `registerUser should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = REGISTER_USER_RESPONSE_JSON)
            .registrationApi
            .registerUser(
                user = RegisterUserRequestJson(
                    email = "test@email.com",
                    fullName = "Test",
                    password = "password",
                    passwordConfirm = "password",
                    username = "username",
                    group = null,
                    household = null,
                    groupToken = null,
                    advanced = false,
                    private = true,
                    seedData = false,
                    locale = "en-US",
                )
            )
            .also { response ->
                assertEquals(
                    createMockRegisterUserResponseJson(),
                    response.getOrNull(),
                )
            }
    }
}

private const val REGISTER_USER_RESPONSE_JSON = """
{
  "username": "username",
  "email": "test@email.com",
  "fullName": "fullName",
  "group": "group",
  "household": "householdId",
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

fun createMockRegisterUserResponseJson() = RegisterUserResponseJson(
    username = "username",
    email = "test@email.com",
    fullName = "fullName",
    group = "group",
    household = "householdId",
    groupId = "groupId",
    advanced = false,
    canManageHousehold = false,
    id = "id",
    authMethod = MealieAuthMethod.MEALIE,
    admin = false,
    canInvite = false,
    canManage = false,
    canOrganize = false,
    groupSlug = "groupSlug",
    householdId = "householdId",
    householdSlug = "householdSlug",
    tokens = listOf(
        RegisterUserResponseJson.MealieToken(
            id = "id",
            name = "name",
            createdAt = "createdAt",
        )
    ),
    cacheKey = "cacheKey",
)
