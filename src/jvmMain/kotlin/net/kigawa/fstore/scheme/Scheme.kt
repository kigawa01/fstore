package net.kigawa.fstore.scheme

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.bson.Document

interface Scheme {
    fun toDocument(): Document = Document.parse(Json.encodeToString(this))

    companion object {

        val json = Json { ignoreUnknownKeys = true }
        inline fun <reified T : Scheme> fromDocument(document: Document): T = json.decodeFromString(document.toJson())
    }
}