package net.kigawa.fstore.service

import com.mongodb.client.MongoDatabase
import io.ktor.server.application.*
import io.ktor.server.config.*
import net.kigawa.fstore.module.DatabaseModule

class MongoDatabase(
    environment: ApplicationEnvironment,
    databaseModule: DatabaseModule,
) {
    val database: MongoDatabase = databaseModule.getDatabase()

}