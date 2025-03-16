package net.kigawa.fstore.domain

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: UserId,
    val name: String,
)
