package net.kigawa.fstore.pages

import kotlinx.html.*

fun HTML.htmlBase(
    stylesheets: List<String> = listOf(),
    headBlock: HEAD.() -> Unit = {},
    bodyBlock: BODY.() -> Unit,
) {
    head {
        headBlock()
        link(rel = "stylesheet", href = "/styles.css", type = "text/css")
        stylesheets.forEach { t ->
            link(rel = "stylesheet", href = t, type = "text/css")
        }
    }
    body {
        bodyBlock()
    }
}