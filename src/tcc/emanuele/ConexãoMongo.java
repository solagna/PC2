/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.emanuele;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 *
 * @author Emanuele
 */
public class ConexãoMongo {

    MongoClient mongoClient;
    DB db;

    DBCollection coll;

    public void conectar() {
        this.mongoClient = new MongoClient("localhost", 27017);
        this.db = mongoClient.getDB("banco");
    }

    public DBCollection getColecao(String c) {
        return coll = db.getCollection(c);
        
    }

}
