//Codigo do DiegoAlgusto do StackOverflow
package com.robson.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost:3306/meu_banco";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        System.out.println("Conexao feita com sucesso!");
        return conn;


    }
}
