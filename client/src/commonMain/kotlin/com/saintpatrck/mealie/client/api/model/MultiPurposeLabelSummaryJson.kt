package com.saintpatrck.mealie.client.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a multi-purpose label.
 */
@Serializable
data class MultiPurposeLabelSummaryJson(
    @SerialName("name")
    val name: String,
    @SerialName("color")
    val color: String = "#959595",
    @SerialName("groupId")
    val groupId: String,
    @SerialName("id")
    val id: String,
)
