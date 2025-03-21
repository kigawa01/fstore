package net.kigawa.fstore.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import net.kigawa.fstore.domain.common.SerializableUuid

class SerializableUuidSerializer : KSerializer<SerializableUuid> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("SerializableUuid", PrimitiveKind.STRING)
    override fun serialize(
        encoder: Encoder, value: SerializableUuid,
    ) {
        encoder.encodeString(value.strUuid)
    }

    override fun deserialize(decoder: Decoder): SerializableUuid {
        return SerializableUuid(decoder.decodeString())
    }
}