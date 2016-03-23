/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.emanuele;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author Emanuele
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
       
        String sql = "";
        try {
            //conexão com o postgreSQL
            ConexaoPostgres c = new ConexaoPostgres();
            c.conectar();

            sql = "select * from produtos";

            ResultSet res = c.executaConsulta(sql);
            List<ClasseObjeto> lista = new ArrayList();

            ClasseObjeto o = null;
            while (res.next()) {
                o = new ClasseObjeto(res.getString("nome"), res.getString("descricao"),
                        res.getDouble("estoque"), res.getDouble("preco"));
                lista.add(o);
            }

            //conexão com o mongoDB
            ConexãoMongo cm = new ConexãoMongo();
            cm.conectar();
            DBCollection coll = cm.getColecao("produtos");

            for (int i = 0; i <= lista.size(); i++) {
                BasicDBObject doc = new BasicDBObject();

                doc.put("nome", lista.get(i).getNome());
                doc.put("descricao", lista.get(i).getDescricao());
                doc.put("estoque", lista.get(i).getEstoque());
                doc.put("preco", lista.get(i).getPreco());

                coll.insert(doc);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
