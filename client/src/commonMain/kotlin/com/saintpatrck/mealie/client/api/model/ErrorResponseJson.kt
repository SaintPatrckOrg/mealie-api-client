package com.saintpatrck.mealie.client.api.model

import com.saintpatrck.mealie.client.infrastructure.serializer.ErrorResponseJsonSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents an error response from the Mealie API.
 */
@Serializable(with = ErrorResponseJsonSerializer::class)
sealed class ErrorResponseJson {

    /**
     * Represents a short error response from the Mealie API.
     *
     * @property detail The error message.
     */
    @Serializable
    data class ShortError(
        @SerialName("detail")
        val detail: String,
    ) : ErrorResponseJson()

    /**
     * Represents a detailed error response from the Mealie API.
     */
    @Serializable
    data class DetailedError(
        @SerialName("detail")
        val detail: List<ErrorDetail>,
    ) : ErrorResponseJson() {

        /**
         * Represents an error detail from the Mealie API.
         *
         * @property location The location of the error.
         * @property message The error message.
         * @property type The type of the error.
         */
        @Serializable
        data class ErrorDetail(
            @SerialName("loc")
            val location: List<String>,
            @SerialName("msg")
            val message: String,
            @SerialName("type")
            val type: String,
        )
    }
}
