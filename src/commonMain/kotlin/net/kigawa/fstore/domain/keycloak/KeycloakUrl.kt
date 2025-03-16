package net.kigawa.fstore.domain.keycloak

import net.kigawa.fstore.domain.common.SerializableUrl

class KeycloakUrl(
    baseUrl: BaseUrl,
    realm: Realm,
) {
    private val url: SerializableUrl = baseUrl.toUrl().appendPath(realm.toStrName())
    fun toUrl() = url
}