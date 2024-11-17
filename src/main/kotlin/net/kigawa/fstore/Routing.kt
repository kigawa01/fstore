package net.kigawa.fstore

import io.ktor.server.application.*
import io.ktor.server.routing.*
import net.kigawa.fstore.pages.top

fun Application.configureRouting() {
    routing {
        top()
    }
}
