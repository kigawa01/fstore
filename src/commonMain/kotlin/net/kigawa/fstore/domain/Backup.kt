package net.kigawa.fstore.domain

import kotlinx.serialization.Serializable
import net.kigawa.fstore.domain.common.SerializableDatetime

@Serializable
data class Backup(
    val id: BackupId,
    val dateTime: SerializableDatetime,
    val directory: DirectoryId,
)
