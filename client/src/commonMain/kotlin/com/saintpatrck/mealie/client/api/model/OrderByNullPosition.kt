package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the position of null values when sorting results.
 */
@Serializable
enum class OrderByNullPosition {
    @SerialName("first")
    FIRST,

    @SerialName("last")
    LAST,
}
