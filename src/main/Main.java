package main;

import java.sql.Connection;
import util.Conexao;

public class Main {
    public static void main(String[] args) {
        Connection conn = Conexao.conectar();

        if (conn != null) {
            System.out.println(" Conexão bem-sucedida com o banco de dados!");
        } else {
            System.out.println(" Falha ao conectar com o banco de dados.");
        }
    }
}