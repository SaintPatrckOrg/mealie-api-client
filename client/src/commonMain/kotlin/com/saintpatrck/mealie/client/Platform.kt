package com.saintpatrck.mealie.client

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform