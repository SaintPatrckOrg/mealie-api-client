package com.saintpatrck.mealie.client.api.user.model

import com.saintpatrck.mealie.client.api.model.Rating
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the response from the /users/self/ratings endpoint.
 *
 * @property ratings The list of ratings.
 */
@Serializable
data class SelfRatingsResponseJson(
    @SerialName("ratings")
    val ratings: List<Rating>,
)
