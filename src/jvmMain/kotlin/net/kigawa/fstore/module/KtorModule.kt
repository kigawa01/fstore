package net.kigawa.fstore.module

import io.ktor.server.application.Application

interface KtorModule {
    fun Application.configure()
}