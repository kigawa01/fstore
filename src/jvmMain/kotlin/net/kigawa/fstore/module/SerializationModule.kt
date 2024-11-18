package net.kigawa.fstore.module

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.kigawa.fstore.module.KtorModule

class SerializationModule : KtorModule {
    override fun Application.configure() {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
        }
    }
}