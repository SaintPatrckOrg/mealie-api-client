package com.saintpatrck.mealie.client.api.about

import com.saintpatrck.mealie.client.api.about.model.AppInfoResponseJson
import com.saintpatrck.mealie.client.api.about.model.AppThemeResponseJson
import com.saintpatrck.mealie.client.api.about.model.StartupInfoResponseJson
import com.saintpatrck.mealie.client.api.base.BaseApiTest
import com.saintpatrck.mealie.client.api.model.getOrNull
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AboutApiTest : BaseApiTest() {

    @Test
    fun `aboutApp should return success with data`() = runTest {
        createTestMealieClient(
            responseJson = ABOUT_RESPONSE_JSON,
        )
            .aboutApi
            .aboutApp()
            .also { response ->
                assertEquals(
                    createMockAppInfoResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `startupInfo should return success with data`() = runTest {
        createTestMealieClient(
            responseJson = STARTUP_INFO_RESPONSE_JSON,
        )
            .aboutApi
            .startupInfo()
            .also { response ->
                assertEquals(
                    createMockStartupInfoResponseJson(),
                    response.getOrNull(),
                )
            }
    }

    @Test
    fun `theme should return success with data`() = runTest {
        createTestMealieClient(
            responseJson = THEME_RESPONSE_JSON,
        )
            .aboutApi
            .theme()
            .also { response ->
                assertEquals(
                    createMockThemeResponseJson(),
                    response.getOrNull(),
                )
            }
    }
}

private val ABOUT_RESPONSE_JSON = """
{
    "production": true,
    "version": "string",
    "demoStatus": true,
    "allowSignup": true,
    "defaultGroupSlug": "string",
    "defaultHouseholdSlug": "string",
    "enableOidc": true,
    "oidcRedirect": true,
    "oidcProviderName": "string",
    "enableOpenai": true,
    "enableOpenaiImageServices": true
}
"""
    .trimIndent()
private val THEME_RESPONSE_JSON = """
{
  "lightPrimary": "#000000",
  "lightAccent": "#007A99",
  "lightSecondary": "#973542",
  "lightSuccess": "#43A047",
  "lightInfo": "#1976D2",
  "lightWarning": "#FF6D00",
  "lightError": "#EF5350",
  "darkPrimary": "#E58325",
  "darkAccent": "#007A99",
  "darkSecondary": "#973542",
  "darkSuccess": "#43A047",
  "darkInfo": "#1976D2",
  "darkWarning": "#FF6D00",
  "darkError": "#EF5350"
}
"""
    .trimIndent()
private val STARTUP_INFO_RESPONSE_JSON = """
{
    "isFirstLogin": true,
    "isDemo": true
}
"""
    .trimIndent()

private fun createMockAppInfoResponseJson(
    production: Boolean = true,
    version: String = "string",
    demoStatus: Boolean = true,
    allowSignup: Boolean = true,
    defaultGroupSlug: String = "string",
    defaultHouseholdSlug: String = "string",
    enableOidc: Boolean = true,
    oidcRedirect: Boolean = true,
    oidcProviderName: String = "string",
    enableOpenai: Boolean = true,
    enableOpenaiImageServices: Boolean = true,
): AppInfoResponseJson = AppInfoResponseJson(
    production = production,
    version = version,
    demoStatus = demoStatus,
    allowSignup = allowSignup,
    defaultGroupSlug = defaultGroupSlug,
    defaultHouseholdSlug = defaultHouseholdSlug,
    enableOidc = enableOidc,
    oidcRedirect = oidcRedirect,
    oidcProviderName = oidcProviderName,
    enableOpenai = enableOpenai,
    enableOpenaiImageServices = enableOpenaiImageServices,
)

private fun createMockStartupInfoResponseJson(
    isFirstLogin: Boolean = true,
    isDemo: Boolean = true,
) = StartupInfoResponseJson(
    isFirstLogin = isFirstLogin,
    isDemo = isDemo,
)

private fun createMockThemeResponseJson(
    lightPrimary: String = "#000000",
    lightAccent: String = "#007A99",
    lightSecondary: String = "#973542",
    lightSuccess: String = "#43A047",
    lightInfo: String = "#1976D2",
    lightWarning: String = "#FF6D00",
    lightError: String = "#EF5350",
    darkPrimary: String = "#E58325",
    darkAccent: String = "#007A99",
    darkSecondary: String = "#973542",
    darkSuccess: String = "#43A047",
    darkInfo: String = "#1976D2",
    darkWarning: String = "#FF6D00",
    darkError: String = "#EF5350",
) = AppThemeResponseJson(
    lightPrimary = lightPrimary,
    lightAccent = lightAccent,
    lightSecondary = lightSecondary,
    lightSuccess = lightSuccess,
    lightInfo = lightInfo,
    lightWarning = lightWarning,
    lightError = lightError,
    darkPrimary = darkPrimary,
    darkAccent = darkAccent,
    darkSecondary = darkSecondary,
    darkSuccess = darkSuccess,
    darkInfo = darkInfo,
    darkWarning = darkWarning,
    darkError = darkError,
)
