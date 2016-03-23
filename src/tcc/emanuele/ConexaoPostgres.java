/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.emanuele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Emanuele
 */
public class ConexaoPostgres {

    Connection con = null;
    Statement stm = null;

    public void conectar() {
        try {
            String url = "jdbc:postgresql://localhost:5432/DB_Produtos";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão efetuada com sucessso!");
        } catch (Exception e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            stm = null;
            con.close();
            System.out.println("Conexão desconectada com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possível finalizar a conexão: " + e.getMessage());
        }
    }

    public String executaAtualizacao(String sql) {
        String erro = "";

        try {
            stm = con.createStatement();
            stm.executeUpdate(sql);
           
            System.out.println("Atualização realizada com sucesso!");
        } catch (Exception e) {
            erro = e.toString();
        }
        return erro;
    }

   
    
    public ResultSet executaConsulta(String sql) {
        try {
            stm = con.createStatement();
            return stm.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

}
