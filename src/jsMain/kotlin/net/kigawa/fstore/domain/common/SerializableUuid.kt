package net.kigawa.fstore.domain.common

import kotlinx.serialization.Serializable
import net.kigawa.fstore.serializer.SerializableUuidSerializer
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable(with = SerializableUuidSerializer::class)
@OptIn(ExperimentalUuidApi::class)
actual open class SerializableUuid actual constructor(
    strUuid: String,
) {
    private val uuid = Uuid.Companion.parse(strUuid)
    actual val strUuid: String
        get() = uuid.toString()
}