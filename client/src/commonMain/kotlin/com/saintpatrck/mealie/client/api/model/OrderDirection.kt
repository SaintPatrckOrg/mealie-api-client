package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the order direction for sorting.
 */
@Serializable
enum class OrderDirection {
    @SerialName("asc")
    ASC,

    @SerialName("desc")
    DESC,
}
