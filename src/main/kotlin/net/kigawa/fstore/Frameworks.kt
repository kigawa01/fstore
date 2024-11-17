package net.kigawa.fstore

import io.ktor.server.application.*
import net.kigawa.fstore.module.DatabaseModule
import net.kigawa.fstore.module.KtorModule
import net.kigawa.fstore.module.SecurityModule
import net.kigawa.fstore.module.SerializationModule
import net.kigawa.fstore.module.TemplateModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.ktor.plugin.KoinApplicationStarted
import org.koin.logger.slf4jLogger

fun Application.configureFrameworks() {
    monitor.subscribe(KoinApplicationStarted) {
        it.koin.getAll<KtorModule>().forEach { t ->
            t.apply {
                configure()
            }
        }
    }
    install(Koin) {
        slf4jLogger()
        modules(module {
            single { this@configureFrameworks }
            singleOf(::SerializationModule) bind KtorModule::class
            singleOf(::DatabaseModule) bind KtorModule::class
            singleOf(::TemplateModule) bind KtorModule::class
            singleOf(::SecurityModule) bind KtorModule::class
        })
    }
}
