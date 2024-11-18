package net.kigawa.fstore.scheme

import kotlinx.serialization.Serializable


@Serializable
data class Project(
    val projectName: String,
) : Scheme {
}
