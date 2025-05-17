package com.saintpatrck.mealie.client.infrastructure.converter

import com.saintpatrck.mealie.client.api.model.MealieResponse
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

/**
 * Converter factory responsible for providing converters to convert [HttpResponse] into a
 * [MealieResponse].
 */
internal object MealieResponseConverterFactory : Converter.Factory {
    override fun suspendResponseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit,
    ): Converter.SuspendResponseConverter<HttpResponse, *>? {
        if (typeData.typeInfo.type == MealieResponse::class) {
            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {
                override suspend fun convert(result: KtorfitResult): Any {
                    return when (result) {
                        is KtorfitResult.Failure -> {
                            MealieResponse.error(result.throwable)
                        }

                        is KtorfitResult.Success -> {
                            if (result.response.status.value in 200..299) {
                                MealieResponse.success(
                                    data = result
                                        .response
                                        .call
                                        .body(typeData.typeArgs.first().typeInfo)
                                )
                            } else {
                                try {
                                    MealieResponse.failure(
                                        code = result.response.status.value,
                                        error = result.response.call.body(),
                                    )
                                } catch (e: Exception) {
                                    MealieResponse.error(e)
                                }
                            }
                        }
                    }
                }
            }
        }
        return null
    }
}
