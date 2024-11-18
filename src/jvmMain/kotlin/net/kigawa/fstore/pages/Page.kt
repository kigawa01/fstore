package net.kigawa.fstore.pages

import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.h1

fun Routing.top() = route("/") {
    get {
        call.respondHtml {
            htmlBase {
                h1(classes = "page-title") {
                    +"Hello from Ktor!"
                }
            }
        }
    }
    get("/styles.css") {
    }
}