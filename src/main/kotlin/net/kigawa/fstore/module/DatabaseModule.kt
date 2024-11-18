package net.kigawa.fstore.module

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import io.ktor.events.*
import io.ktor.server.application.*
import io.ktor.server.config.*

class DatabaseModule(
    environment: ApplicationEnvironment,
    monitor: Events,
) : KtorModule {
    private val user = environment.config.tryGetString("db.mongo.user")
    private val password = environment.config.tryGetString("db.mongo.password")
    private val host = environment.config.tryGetString("db.mongo.host") ?: "127.0.0.1"
    private val port = environment.config.tryGetString("db.mongo.port") ?: "27017"
    private val maxPoolSize = environment.config.tryGetString("db.mongo.maxPoolSize")?.toInt() ?: 20
    private val credentials = user?.let { userVal -> password?.let { passwordVal -> "$userVal:$passwordVal@" } }.orEmpty()
    private val uri = "mongodb://$credentials$host:$port/?maxPoolSize=$maxPoolSize&w=majority"
    private val client: MongoClient = MongoClients.create(uri)
    private val databaseName = environment.config.tryGetString("db.mongo.database.name") ?: "fstore"

    init {
        monitor.subscribe(ApplicationStopped) {
            client.close()
        }
    }

    fun getDatabase(): MongoDatabase = client.getDatabase(databaseName)

    override fun Application.configure() {
    }
}