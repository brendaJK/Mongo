package com.brenda.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ConexionNube {


    ConnectionString connectionString = new ConnectionString("mongodb://mongo:J6HNfX23fLFfCsvgmuOm@containers-us-west-131.railway.app:6837");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("Tienda");

    public boolean insertar(Tienda tienda){
        MongoCollection<Document> collection=database.getCollection("refresquitos");
        Document document=new Document("idProducto", tienda.getIdRefresco())
                .append("nombre", tienda.getNombre())
                .append("existencias", tienda.getExistencias())
                .append("tamanio", tienda.getTamanio())
                .append("precio", tienda.getPrecio());
        collection.insertOne(document);
        return true;
    }

    public boolean actualizar(Tienda productoAnterior, Tienda productoNuevo){
        MongoCollection<Document> collection = database.getCollection("refresquitos");
        Bson filter = Filters.eq("idProducto", productoAnterior.getIdRefresco());
        Document document = new Document("idProducto",productoNuevo.getIdRefresco())
                .append("nombre", productoNuevo.getNombre())
                .append("existencias", productoNuevo.getExistencias())
                .append("tamanio", productoNuevo.getTamanio())
                .append("precio", productoNuevo.getPrecio());

        Bson update = new Document("$set", document);
        UpdateResult result = collection.updateOne(filter, update);
        System.out.println(result.getModifiedCount() + " documento actualizado");
        return true;
    }

    public boolean mostrar() {
        try {
            MongoCollection<Document> collection = database.getCollection("refresquitos");
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {
                System.out.println(document.toJson());
            }
            return true;
        } catch (Exception e){
            System.out.println("error");
            return false;
        }
    }

    public boolean eliminar(int idRefresquito){
        MongoCollection<Document> collection = database.getCollection("refresquitos");
        Bson filter = Filters.eq("idRefresquito", idRefresquito);
        DeleteResult result = collection.deleteOne(filter);
        System.out.println(result.getDeletedCount() + " documento eliminado");
        return true;
    }

}
