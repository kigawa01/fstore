package net.kigawa.fstore.domain

import kotlinx.serialization.Serializable

@Serializable
data class File(
    val id: FileId,
    val name: String,
)
