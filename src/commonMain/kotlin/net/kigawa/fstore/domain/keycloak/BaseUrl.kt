package net.kigawa.fstore.domain.keycloak

import net.kigawa.fstore.domain.common.SerializableUrl

data class BaseUrl(
    private val url: SerializableUrl,
) {
    fun toUrl() = url
}