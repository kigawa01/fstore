package net.kigawa.fstore.module

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.CSSBuilder
import kotlinx.html.*

class TemplateModule : KtorModule {
    override fun Application.configure() {
        routing {
            get("/html-dsl") {
                call.respondHtml {
                    body {
                        h1 { +"HTML" }
                        ul {
                            for (n in 1..10) {
                                li { +"$n" }
                            }
                        }
                    }
                }
            }

            get("/html-css-dsl") {
                call.respondHtml {
                    head {
                        link(rel = "stylesheet", href = "/styles.css", type = "text/css")
                    }
                    body {
                        h1(classes = "page-title") {
                            +"Hello from Ktor!"
                        }
                    }
                }
            }
        }
    }

    suspend inline fun respondCss(call: ApplicationCall, builder: CSSBuilder.() -> Unit) {
        call.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
    }

}