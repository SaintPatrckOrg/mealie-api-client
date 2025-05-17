package com.saintpatrck.mealie.client.api.user

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.MealieToken
import com.saintpatrck.mealie.client.api.model.Rating
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.registration.model.MealieAuthMethod
import com.saintpatrck.mealie.client.api.user.model.SelfFavoritesResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfRatingsResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfResponseJson
import com.saintpatrck.mealie.client.api.user.model.UpdatePasswordRequestJson
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

    @Test
    fun `ratings should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = SELF_RATINGS_RESPONSE_JSON)
            .userApi
            .ratings()
            .also { response ->
                assertEquals(
                    createMockSelfRatingsResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `ratingForRecipe should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = SELF_RATING_FOR_RECIPE_RESPONSE_JSON)
            .userApi
            .ratingForRecipe("recipeId")
            .also { response ->
                assertEquals(
                    createMockRatingForRecipeResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `favorites should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = SELF_FAVORITES_RESPONSE_JSON)
            .userApi
            .favorites()
            .also { response ->
                assertEquals(
                    createMockSelfFavoritesResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `updatePassword should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .userApi
            .updatePassword(
                updatePasswordRequestJson = UpdatePasswordRequestJson(
                    currentPassword = "currentPassword",
                    newPassword = "newPassword",
                )
            )
            .also { response ->
                assertEquals(
                    Unit,
                    response.getOrNull(),
                )
            }
    }
}

private val SELF_RESPONSE_JSON = """
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
    .trimIndent()
private val SELF_RATINGS_RESPONSE_JSON = """
{
  "ratings": [
    {
      "recipeId": "recipeId",
      "rating": 1.0,
      "isFavorite": false
    }
  ]
}
"""
    .trimIndent()
private val SELF_RATING_FOR_RECIPE_RESPONSE_JSON = """
{
  "recipeId": "recipeId",
  "rating": 1.0,
  "isFavorite": false
}
"""
    .trimIndent()
private val SELF_FAVORITES_RESPONSE_JSON = """
{
  "ratings": [
    {
      "recipeId": "recipeId",
      "rating": 1.0,
      "isFavorite": false
    }
  ]
}
"""
    .trimIndent()

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

private fun createMockSelfRatingsResponseJson() = SelfRatingsResponseJson(
    ratings = listOf(
        Rating(
            recipeId = "recipeId",
            rating = 1.0,
            isFavorite = false,
        )
    ),
)

private fun createMockRatingForRecipeResponseJson() = Rating(
    recipeId = "recipeId",
    rating = 1.0,
    isFavorite = false,
)

private fun createMockSelfFavoritesResponseJson() = SelfFavoritesResponseJson(
    ratings = listOf(
        Rating(
            recipeId = "recipeId",
            rating = 1.0,
            isFavorite = false,
        )
    ),
)

