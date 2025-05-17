package com.saintpatrck.mealie.client.infrastructure.serializer

import com.saintpatrck.mealie.client.api.model.ErrorResponseJson
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject

/**
 * Serializer for [ErrorResponseJson].
 */
internal object ErrorResponseJsonSerializer :
    JsonContentPolymorphicSerializer<ErrorResponseJson>(ErrorResponseJson::class) {
    override fun selectDeserializer(
        element: JsonElement,
    ): DeserializationStrategy<ErrorResponseJson> {
        val jsonObject = element.jsonObject
        return when {
            jsonObject["detail"] is JsonPrimitive -> ErrorResponseJson.ShortError.serializer()
            jsonObject["detail"] is JsonArray -> ErrorResponseJson.DetailedError.serializer()
            else -> throw SerializationException("Unknown error response format: $jsonObject")
        }
    }
}