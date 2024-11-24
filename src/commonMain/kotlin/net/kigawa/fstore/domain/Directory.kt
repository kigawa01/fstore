package net.kigawa.fstore.domain

import kotlinx.serialization.Serializable

@Serializable
data class Directory(
    val subDirectories: List<DirectoryId>,
    val files: List<File>,
)
