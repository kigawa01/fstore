package net.kigawa.fstore.domain.common

import kotlinx.serialization.Serializable
import net.kigawa.fstore.serializer.SerializableDatetimeSerializer

@Serializable(with = SerializableDatetimeSerializer::class)
class SerializableDatetime(
    val utcTime: Long,
)