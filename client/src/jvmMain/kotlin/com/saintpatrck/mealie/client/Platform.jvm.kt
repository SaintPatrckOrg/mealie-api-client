package com.saintpatrck.mealie.client

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine

/**
 * JVM implementation of [Platform].
 */
internal object JvmPlatform : Platform {

    override val name: String = "JVM"

    override val httpClientEngineConfig: HttpClientEngine
        get() = OkHttpEngine(
            config = OkHttpConfig().apply {
                config {
                    retryOnConnectionFailure(true)
                }
            }
        )

}

internal actual val platform: Platform get() = JvmPlatform
