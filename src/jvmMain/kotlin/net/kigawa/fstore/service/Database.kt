package net.kigawa.fstore.service

import com.mongodb.client.MongoDatabase
import net.kigawa.fstore.module.DatabaseModule

class Database(
    databaseModule: DatabaseModule,
) {
    val database: MongoDatabase = databaseModule.getDatabase()

}