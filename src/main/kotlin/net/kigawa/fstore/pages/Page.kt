package net.kigawa.fstore.pages

import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.h1
import net.kigawa.fstore.module.TemplateModule
import org.koin.ktor.ext.inject

fun Routing.top() = route("/") {
    val template by inject<TemplateModule>()
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
        template.respondCss(call) {
            body {
//                backgroundColor = Color.darkBlue
                margin(0.px)
            }
            rule("h1.page-title") {
                color = Color.white
            }
        }
    }
}