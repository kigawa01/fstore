package net.kigawa.fstore

import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain
import io.kvision.remote.kvisionInit

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureFrameworks()
    configureRouting()
    kvisionInit()
}
