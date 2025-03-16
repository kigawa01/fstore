package net.kigawa.fstore.domain.keycloak

data class KeycloakClient(
    private val baseUrl: BaseUrl,
    private val realm: Realm,
) {
    private val keycloakUrl: KeycloakUrl = KeycloakUrl(baseUrl, realm)
}