package net.kigawa.fstore.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import net.kigawa.fstore.domain.common.SerializableDatetime

class SerializableDatetimeSerializer : KSerializer<SerializableDatetime> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("SerializableDatetime", PrimitiveKind.LONG)
    override fun serialize(
        encoder: Encoder, value: SerializableDatetime,
    ) {
        encoder.encodeLong(value.utcTime)
    }


    override fun deserialize(decoder: Decoder): SerializableDatetime {
        val utcTime = decoder.decodeLong()
        return SerializableDatetime(utcTime)
    }
}