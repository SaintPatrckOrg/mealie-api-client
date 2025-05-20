package com.saintpatrck.mealie.client.api.user

import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.MealieToken
import com.saintpatrck.mealie.client.api.model.PagedResponseJson
import com.saintpatrck.mealie.client.api.model.Rating
import com.saintpatrck.mealie.client.api.model.getOrNull
import com.saintpatrck.mealie.client.api.user.model.CreateApiTokenRequestJson
import com.saintpatrck.mealie.client.api.user.model.CreateApiTokenResponseJson
import com.saintpatrck.mealie.client.api.user.model.CreateUserRequestJson
import com.saintpatrck.mealie.client.api.user.model.DeleteTokenResponseJson
import com.saintpatrck.mealie.client.api.user.model.ForgotPasswordRequestJson
import com.saintpatrck.mealie.client.api.user.model.MealieAuthMethod
import com.saintpatrck.mealie.client.api.user.model.RegisterUserRequestJson
import com.saintpatrck.mealie.client.api.user.model.RegisterUserResponseJson
import com.saintpatrck.mealie.client.api.user.model.ResetPasswordRequestJson
import com.saintpatrck.mealie.client.api.user.model.SelfFavoritesResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfRatingsResponseJson
import com.saintpatrck.mealie.client.api.user.model.SelfResponseJson
import com.saintpatrck.mealie.client.api.user.model.UpdatePasswordRequestJson
import com.saintpatrck.mealie.client.api.user.model.UpdateUserRequestJson
import com.saintpatrck.mealie.client.api.user.model.UserResponseJson
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
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

    @Test
    fun `updateUser should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .userApi
            .updateUser(
                userId = "userId",
                updateUserRequestJson = UpdateUserRequestJson(
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
                )
            )
            .also { response ->
                assertEquals(
                    Unit,
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `getUser should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = USER_RESPONSE_JSON)
            .userApi
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
            .userApi
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
            .userApi
            .getAllUsers()
            .also {
                assertEquals(
                    createMockPagedUserResponseJson(),
                    it.getOrNull(),
                )
            }
    }

    @Test
    fun `createUser should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = USER_RESPONSE_JSON)
            .userApi
            .createUser(
                user = CreateUserRequestJson(
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
                    password = "password",
                )
            )
            .also {
                assertEquals(
                    createMockUserResponseJson(),
                    it.getOrNull(),
                )
            }
    }

    @Test
    fun `forgotPassword should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .userApi
            .forgotPassword(
                forgotPasswordRequest = ForgotPasswordRequestJson(
                    email = "email",
                )
            )
            .also {
                assertEquals(
                    Unit,
                    it.getOrNull(),
                )
            }
    }

    @Test
    fun `resetPassword should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = "")
            .userApi
            .resetPassword(
                resetPasswordRequest = ResetPasswordRequestJson(
                    token = "token",
                    email = "email",
                    password = "password",
                    passwordConfirm = "passwordConfirm",
                )
            )
            .also {
                assertEquals(
                    Unit,
                    it.getOrNull(),
                )
            }
    }

    @Test
    fun `registerUser should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = REGISTER_USER_RESPONSE_JSON)
            .userApi
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

    @Test
    fun `createApiToken should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = CREATE_API_TOKEN_RESPONSE_JSON)
            .userApi
            .createApiToken(
                createApiTokenRequestJson = CreateApiTokenRequestJson(
                    name = "name",
                    integrationId = "integrationId",
                )
            )
            .also { response ->
                assertEquals(
                    createMockCreateApiTokenResponse(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `deleteApiToken should deserialize correctly`() = runTest {
        createTestMealieClient(responseJson = DELETE_TOKEN_RESPONSE_JSON)
            .userApi
            .deleteApiToken(1)
            .also { response ->
                assertEquals(
                    createMockDeleteJsonResponse(),
                    response.getOrNull(),
                )
            }
    }
}

private val DELETE_TOKEN_RESPONSE_JSON = """
{
  "tokenDelete": "tokenDelete"
}
"""
    .trimIndent()
private val CREATE_API_TOKEN_RESPONSE_JSON = """
{
  "name": "name",
  "id": 0,
  "createdAt": "2019-08-24T14:15:22Z",
  "token": "token"
} 
"""
    .trimIndent()
private val REGISTER_USER_RESPONSE_JSON = """
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
    .trimIndent()
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
private val USER_RESPONSE_JSON = """
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
    $USER_RESPONSE_JSON
  ],
  "next": "string",
  "previous": "string"
}
""".trimIndent()

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
        MealieToken(
            id = "id",
            name = "name",
            createdAt = "createdAt",
        )
    ),
    cacheKey = "cacheKey",
)

fun createMockCreateApiTokenResponse() = CreateApiTokenResponseJson(
    name = "name",
    id = 0,
    createdAt = Instant.parse("2019-08-24T14:15:22Z"),
    token = "token",
)

fun createMockDeleteJsonResponse() = DeleteTokenResponseJson(
    tokenDelete = "tokenDelete",
)
