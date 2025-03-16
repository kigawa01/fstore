package net.kigawa.fstore.domain.keycloak

import net.kigawa.fstore.domain.common.SerializableUrl

class WellKnownUrl(
    keycloakUrl: KeycloakUrl
) {
    private val url: SerializableUrl = keycloakUrl.toUrl().appendPath(".well-known/openid-configuration")
}