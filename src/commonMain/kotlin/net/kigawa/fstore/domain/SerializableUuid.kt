package net.kigawa.fstore.domain

import kotlinx.serialization.Serializable
import net.kigawa.fstore.serializer.SerializableUuidSerializer

@Serializable(with = SerializableUuidSerializer::class)
expect open class SerializableUuid(
    strUuid: String,
) {
    val strUuid: String
}