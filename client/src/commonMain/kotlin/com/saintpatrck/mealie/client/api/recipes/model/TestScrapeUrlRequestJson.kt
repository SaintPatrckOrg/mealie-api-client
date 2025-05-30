package com.saintpatrck.mealie.client.api.recipes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a test scrape url request.
 *
 * @param url The URL to scrape.
 * @param useOpenAi Whether to use OpenAI to scrape the URL.
 */
@Serializable
data class TestScrapeUrlRequestJson(
    @SerialName("url")
    val url: String,
    @SerialName("useOpenAI")
    val useOpenAi: Boolean = false,
)
