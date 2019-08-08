//Parte do codigo do DiegoAlgusto do StackOverflow
package com.robson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.robson.atores.Pessoa;
import com.robson.conexao.Conexao;

public class PessoaDAO {
	
   
    public List<Pessoa> buscar(Pessoa p) throws Exception {
        /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id_pessoa, nome_pessoa, idade_cliente, status_pessoa ");
        sql.append("FROM tabela_pessoa ");
        sql.append("WHERE id_pessoa LIKE ? ");
        sql.append("ORDER BY nome_cliente ");
        
        /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        comando.setString(1, "%" + p.getNome()+ "%");

        /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<Pessoa> lista = new ArrayList<Pessoa>();

        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
            /* Cria um objeto para armazenar uma linha da consulta */
            Pessoa linha = new Pessoa();
            linha.setId(resultado.getInt("id_pessoa"));
            linha.setNome(resultado.getString("nome_pessoa"));
            linha.setIdade(resultado.getString("idade_pessoa"));
            linha.setStatus(resultado.getString("status_pessoa"));
            /* Armazena a linha lida em uma lista */
            lista.add(linha);
        }

        /* Fecha a conexão */
        resultado.close();
        comando.close();
        conn.close();

        /* Retorna a lista contendo o resultado da consulta */
        return lista;
    }
    
    public void inserir(Pessoa pessoa) throws Exception {
    	/* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();
    	
    	   PreparedStatement p = conn.prepareStatement
    	   ("insert into tabela_pessoa (nome_pessoa, id_pessoa, idade_pessoa, status_pessoa) values (?,?,?,?)");
    	   p.setString(1, pessoa.getNome());
    	   p.setLong(2, pessoa.getId());
    	   p.setString(3, pessoa.getIdade());
    	   p.setString(4, pessoa.getStatus());
    	   p.executeUpdate();
    	   p.close();
    	}
    public void deletar(Pessoa pessoa) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
    	   Connection conn = Conexao.abrir();
    	   PreparedStatement p = conn.prepareStatement("delete from tabela_pessoa where id_pessoa = ?");
    	   p.setInt(1, pessoa.getId());
    	   p.executeUpdate();
    	   p.close();
    	}
    public void update(Pessoa pessoa) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
 	       Connection conn = Conexao.abrir();
    	   PreparedStatement p = 
    	   conn.prepareStatement
    	   ("update tabela_pessoa set nome_pessoa = ?, idade_pessoa = ?, status_pessoa = ? where id_pessoa = ?");
    	   p.setString(1, pessoa.getNome());
    	   p.setLong(2, pessoa.getId());
    	   p.setString(3, pessoa.getIdade());
    	   p.setString(4, pessoa.getStatus());
    	   p.executeUpdate();
    	   p.close();
    	}
 }
