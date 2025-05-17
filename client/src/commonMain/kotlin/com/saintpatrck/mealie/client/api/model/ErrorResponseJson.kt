package com.saintpatrck.mealie.client.api.model

import com.saintpatrck.mealie.client.infrastructure.serializer.ErrorResponseJsonSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models possible error responses from the Mealie API.
 */
@Serializable(with = ErrorResponseJsonSerializer::class)
sealed class ErrorResponseJson {

    /**
     * Models a short error response from the Mealie API.
     *
     * @property detail The error message.
     */
    @Serializable
    data class Unauthorized(
        @SerialName("detail")
        val detail: String,
    ) : ErrorResponseJson()

    /**
     * Models a Validation error response from the Mealie API with multiple errors.
     *
     * @property detail The list of validation errors.
     */
    @Serializable
    data class ValidationErrors(
        @SerialName("detail")
        val detail: List<ValidationError>,
    ) : ErrorResponseJson() {

        /**
         * Represents a validation error from the Mealie API.
         *
         * @property location The location of the error.
         * @property message The error message.
         * @property type The type of the error.
         */
        @Serializable
        data class ValidationError(
            @SerialName("loc")
            val location: List<String>,
            @SerialName("msg")
            val message: String,
            @SerialName("type")
            val type: String?,
        )
    }

    /**
     * Represents a Forbidden error response from the Mealie API.
     *
     * @property detail The error detail.
     */
    @Serializable
    data class Forbidden(
        @SerialName("detail")
        val detail: Detail,
    ) : ErrorResponseJson() {
        /**
         * Represents the detail of the Forbidden response from the Mealie API.
         *
         * @property message The error message.
         * @property error TODO
         * @property exception The exception type.
         */
        @Serializable
        data class Detail(
            @SerialName("message")
            val message: String,
            @SerialName("error")
            val error: Boolean,
            @SerialName("exception")
            val exception: String?,
        )
    }
}
