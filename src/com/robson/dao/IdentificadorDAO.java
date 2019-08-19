package com.robson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.robson.atores.Identificador;
import com.robson.atores.Pessoa;
import com.robson.conexao.Conexao;

public class IdentificadorDAO {
	
	public List<Identificador> buscar(Pessoa i) throws Exception {
        /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT nome_pessoa, tempo_partida, tempo_saida, tarifa_total");
        sql.append("FROM tabela_identificador ");
        sql.append("WHERE nome_pessoa LIKE ? ");
        sql.append("ORDER BY ASC ");
        
        /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        comando.setString(1, "%" + i.getNome()+ "%");

        /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<Identificador> lista = new ArrayList<Identificador>();

        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
            /* Cria um objeto para armazenar uma linha da consulta */
            Identificador linha = new Identificador();
            linha.setPessoa(resultado.getString("nome_pessoa"));
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
        System.out.println("Busca feita com sucesso!");
        /* Retorna a lista contendo o resultado da consulta */
        return lista;
    }
    
    public void inserir(Identificador i) throws Exception {
    	/* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();
    	
    	   PreparedStatement p = conn.prepareStatement
    	   ("insert into tabela_identificador (nome_pessoa , tempo_partida) "
    	   	+ "values (?,?)");
    	   p.setString(1, i.getNome());
    	   p.setLong(2, i.getTempoPartida());
    	   p.executeUpdate();
    	   System.out.println("Inserido com sucesso!");
    	   p.close();
    	}
    public void deletar(Identificador i) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
    	   Connection conn = Conexao.abrir();
    	   PreparedStatement p = conn.prepareStatement("delete from tabela_identificador where nome_pessoa = ?");
    	   p.setString(1, i.getNome());
    	   p.executeUpdate();
    	   System.out.println("Deletado com sucesso!");
    	   p.close();
    	}
    public void update(Identificador i) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
 	       Connection conn = Conexao.abrir();
    	   PreparedStatement p = 
    	   conn.prepareStatement
    	   ("update tabela_identificador set tempo_saida = ?, tarifa_total = ? where nome_pessoa = ?");

    	   p.setLong(1, i.getTempoSaida());
    	   p.setDouble(2, i.getTarifaTotal());
    	   p.setString(3, i.getNome());
    	   p.executeUpdate();
    	   System.out.println("Atualizado com sucesso!");
    	   p.close();
    	}
}
