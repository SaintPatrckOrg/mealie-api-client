package com.saintpatrck.mealie.client.api.model

/**
 * Represents a response from the Mealie API.
 */
sealed class MealieResponse<T> {

    /**
     * Represents a successful response from the Mealie API.
     */
    data class Success<T>(val data: T) : MealieResponse<T>()

    /**
     * Represents a failed response from the Mealie API.
     */
    data class Failure(
        val code: Int,
        val error: ErrorResponseJson?,
    ) : MealieResponse<Nothing>()

    /**
     * Represents an error response from the Mealie API.
     */
    data class Error(val throwable: Throwable) : MealieResponse<Nothing>()

    internal companion object {
        /**
         * Creates a [Success] response with the given [data].
         */
        internal fun <T> success(data: T) = Success(data)

        /**
         * Creates a [Failure] response with the given [code] and [error].
         */
        internal fun failure(code: Int, error: ErrorResponseJson?) = Failure(code, error)

        /**
         * Creates an [Error] response with the given [throwable].
         */
        internal fun error(throwable: Throwable) = Error(throwable)
    }
}


/**
 * Executes the given [action] if the [MealieResponse] is a [MealieResponse.Success]. Returns the
 * original [MealieResponse] unchanged.
 */
inline fun <T> MealieResponse<T>.onSuccess(
    action: (T) -> Unit
): MealieResponse<T> {
    getOrNull()?.let { action(it) }
    return this
}

/**
 * Executes the given [action] if the [MealieResponse] is a [MealieResponse.Failure]. Returns the
 * original [MealieResponse] unchanged.
 */
inline fun <T> MealieResponse<T>.onFailure(
    action: (MealieResponse.Failure) -> Unit
): MealieResponse<T> {
    failureOrNull()?.let { action(it) }
    return this
}

/**
 * Executes the given [action] if the [MealieResponse] is a [MealieResponse.Error]. Returns the
 * original [MealieResponse] unchanged.
 */
inline fun <T> MealieResponse<T>.onError(
    action: (Throwable) -> Unit
): MealieResponse<T> {
    exceptionOrNull()?.let { action(it) }
    return this
}

/**
 * Returns the value of the [MealieResponse] if it is a [MealieResponse.Success], otherwise returns
 * `null`.
 */
fun <T> MealieResponse<T>.getOrNull(): T? =
    (this as? MealieResponse.Success)?.data

/**
 * Returns the value of the [MealieResponse] if it is a [MealieResponse.Success], otherwise throws
 * an [IllegalStateException].
 */
fun <T> MealieResponse<T>.getOrThrow(): T =
    getOrNull() ?: throw exceptionOrNull() ?: IllegalStateException("Unknown error")

/**
 * Returns the [MealieResponse.Failure] of the [MealieResponse] if it is a [MealieResponse.Failure],
 * otherwise returns `null`.
 */
fun <T> MealieResponse<T>.failureOrNull(): MealieResponse.Failure? =
    this as? MealieResponse.Failure

/**
 * Returns the [MealieResponse.Failure] of the [MealieResponse] if it is a [MealieResponse.Failure],
 */
fun <T> MealieResponse<T>.failureOrThrow(): MealieResponse.Failure =
    failureOrNull() ?: throw IllegalStateException("Response is not a failure")

/**
 * Returns the [Throwable] of the [MealieResponse] if it is a [MealieResponse.Error], otherwise
 * returns `null`.
 */
fun <T> MealieResponse<T>.exceptionOrNull(): Throwable? =
    (this as? MealieResponse.Error)?.throwable