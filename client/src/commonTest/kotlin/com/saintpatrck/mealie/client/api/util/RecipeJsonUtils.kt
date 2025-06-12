package com.saintpatrck.mealie.client.api.util

import com.saintpatrck.mealie.client.api.model.RecipeCategoryJson
import com.saintpatrck.mealie.client.api.model.RecipeJson
import com.saintpatrck.mealie.client.api.model.RecipeTagJson
import com.saintpatrck.mealie.client.api.model.RecipeToolJson
import kotlinx.datetime.Instant

/**
 * JSON string representing a [RecipeJson] for testing.
 */
val RECIPE_JSON = """
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
"""
    .trimIndent()
val RECIPE_LIST_JSON = """
[
    $RECIPE_JSON
]
"""
    .trimIndent()

/**
 * Create a mock [RecipeJson] for testing.
 */
fun createMockRecipeJson() = RecipeJson(
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

/**
 * Create a mock [RecipeCategoryJson] for testing.
 */
fun createMockRecipeCategory() = RecipeCategoryJson(
    id = "id",
    name = "name",
    slug = "slug",
)

/**
 * Create a mock [RecipeTagJson] for testing.
 */
fun createMockRecipeTag() = RecipeTagJson(
    id = "id",
    name = "name",
    slug = "slug",
)

/**
 * Create a mock [RecipeToolJson] for testing.
 */
fun createMockRecipeTool() = RecipeToolJson(
    id = "id",
    name = "name",
    slug = "slug",
    householdsWithTool = listOf("householdsWithTool")
)
