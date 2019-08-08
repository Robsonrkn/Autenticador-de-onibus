package com.robson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.robson.atores.Identificador;
import com.robson.conexao.Conexao;

public class IdentificadorDAO {
	
	public List<Identificador> buscar(Identificador i) throws Exception {
        /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, nome_pessoa, tempo_partida, tempo_saida, tarifa_total");
        sql.append("FROM tabela_identificador ");
        sql.append("WHERE nome_pessoa LIKE ? ");
        sql.append("ORDER BY id ");
        
        /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        comando.setString(1, "%" + i.getPessoa()+ "%");

        /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<Identificador> lista = new ArrayList<Identificador>();

        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
            /* Cria um objeto para armazenar uma linha da consulta */
            Identificador linha = new Identificador();
            linha.setId(resultado.getInt("id"));
            linha.setPessoa(resultado.getObject("nome_pessoa"));
            linha.setTempoPartida(resultado.getLong("tempo_partida"));
            linha.setTempoSaida(resultado.getLong("tempo_saida"));
            linha.setTarifaTotal(resultado.getDouble("tarifa_total"));
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
    
    public void inserir(Identificador i) throws Exception {
    	/* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();
    	
    	   PreparedStatement p = conn.prepareStatement
    	   ("insert into tabela_identificador (id, nome_pessoa , tempo_partida, tempo_saida, tarifa_total) "
    	   	+ "values (?,?,?,?,?)");
    	   p.setInt(1, i.getId());
    	   p.setObject(2, i.getPessoa());
    	   p.setDouble(3, i.getTempoPartida());
    	   p.setDouble(4, i.getTempoSaida());
    	   p.setDouble(5, i.getTarifaTotal());
    	   p.executeUpdate();
    	   p.close();
    	}
    public void deletar(Identificador i) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
    	   Connection conn = Conexao.abrir();
    	   PreparedStatement p = conn.prepareStatement("delete from tabela_identificador where destino_onibus = ?");
    	   p.setInt(1, i.getId());
    	   p.executeUpdate();
    	   p.close();
    	}
    public void update(Identificador i) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
 	       Connection conn = Conexao.abrir();
    	   PreparedStatement p = 
    	   conn.prepareStatement
    	   ("update tabela_identificador set nome_pessoa = ?, tempo_saida = ?, tarifa_total = ? where destino_onibus = ?");
    	  
    	   p.setObject(1, i.getPessoa());
    	   p.setLong(2, i.getTempoSaida());
    	   p.setDouble(3, i.getTarifaTotal());
    	   p.setInt(4 , i.getId());
    	   p.executeUpdate();
    	   p.close();
    	}
}
