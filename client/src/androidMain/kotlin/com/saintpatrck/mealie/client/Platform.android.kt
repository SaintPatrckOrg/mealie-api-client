package com.saintpatrck.mealie.client

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine

/**
 * Android implementation of [Platform].
 */
internal object AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"

    override val httpClientEngineConfig: HttpClientEngine
        get() = OkHttpEngine(
            config = OkHttpConfig().apply {
                config {
                    retryOnConnectionFailure(true)
                }
            }
        )
}

internal actual val platform: Platform get() = AndroidPlatform
