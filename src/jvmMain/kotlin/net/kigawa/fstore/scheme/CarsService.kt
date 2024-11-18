package net.kigawa.fstore.scheme

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.bson.Document
import org.bson.types.ObjectId

class CarService(private val database: MongoDatabase) {
    var collection: MongoCollection<Document>

    init {
        if (!database.listCollectionNames().toList().contains("cars")) database.createCollection("cars")
        collection = database.getCollection("cars")
    }

    // Create new car
    suspend fun create(project: Project): String = withContext(Dispatchers.IO) {
        val doc = project.toDocument()
        collection.insertOne(doc)
        doc["_id"].toString()
    }

    // Read a car
    suspend fun read(id: String): Project? = withContext(Dispatchers.IO) {
        collection.find(Filters.eq("_id", ObjectId(id))).first()?.let { Scheme.fromDocument<Project>(it) }
    }

    // Update a car
    suspend fun update(id: String, project: Project): Document? = withContext(Dispatchers.IO) {
        collection.findOneAndReplace(Filters.eq("_id", ObjectId(id)), project.toDocument())
    }

    // Delete a car
    suspend fun delete(id: String): Document? = withContext(Dispatchers.IO) {
        collection.findOneAndDelete(Filters.eq("_id", ObjectId(id)))
    }
}

