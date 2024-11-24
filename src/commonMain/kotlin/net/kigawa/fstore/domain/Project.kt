package net.kigawa.fstore.domain

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: ProjectId,
    val name: String,
    val backups: List<Backup>,
) {
}