package net.kigawa.fstore.domain.common

import io.ktor.http.*

class SerializableUrl(
    private val url: Url,
) : AbstractUrl() {
    companion object {
        fun parse(strUrl: String): SerializableUrl {
            val url = parseUrl(strUrl) ?: throw UrlParseException("invalid url $strUrl")
            return SerializableUrl(url)
        }
    }

    fun toKtorUrl() = url
    fun appendPath(path: String) = URLBuilder(toKtorUrl())
        .appendEncodedPathSegments(path)
        .build()
        .let { SerializableUrl(it) }
}