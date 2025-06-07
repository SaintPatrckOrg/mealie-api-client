package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a paged response from the Mealie API.
 */
@Serializable
data class PagedResponseJson<T>(
    @SerialName("page")
    val page: Int,
    @SerialName("per_page")
    val perPage: Int,
    @SerialName("total")
    val total: Int?,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("items")
    val items: List<T>,
    @SerialName("next")
    val next: String?,
    @SerialName("previous")
    val previous: String?,
)
