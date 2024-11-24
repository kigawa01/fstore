package net.kigawa.fstore.domain

import kotlinx.serialization.Serializable

@Serializable
data class Backup(
    val id: BackupId,
    val dateTime: SerializableDatetime,
    val directory: DirectoryId,
)
