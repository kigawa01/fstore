package net.kigawa.fstore.domain.keycloak

import io.ktor.util.toCharArray

data class Realm(
    private val name: String,
) {
    init {
        name.toCharArray().forEach {
            if (it in '0'..'9') return@forEach
            if (it in 'a'..'z') return@forEach
            if (it in 'A'..'Z') return@forEach
            if (it == '-') return@forEach

            throw IllegalArgumentException("invalid char of realm: letter $it")
        }

        if (name == "") throw IllegalArgumentException("realm is empty")
    }

    fun toStrName() = name
}