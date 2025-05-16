package com.saintpatrck.mealie.client

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.engine.darwin.DarwinClientEngineConfig
import platform.UIKit.UIDevice

/**
 * iOS implementation of [Platform].
 */
internal object IOSPlatform : Platform {
    override val name: String =
        "${UIDevice.currentDevice.systemName()} ${UIDevice.currentDevice.systemVersion}"

    override val httpClientEngineConfig: HttpClientEngine
        get() = Darwin.create {
            DarwinClientEngineConfig().apply {
                configureRequest { setAllowsCellularAccess(true) }
            }
        }
}

internal actual val platform: Platform get() = IOSPlatform
