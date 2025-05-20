package com.saintpatrck.mealie.client.api.user.model

import com.saintpatrck.mealie.client.api.model.Rating
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a collection of [Rating].
 *
 * @property ratings The list of ratings.
 */
@Serializable
data class RatingsResponseJson(
    @SerialName("ratings")
    val ratings: List<Rating>,
)
