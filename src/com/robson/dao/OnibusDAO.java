package com.robson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.robson.atores.Onibus;
import com.robson.conexao.Conexao;

public class OnibusDAO {
	
	   
	public List<Onibus> buscar(Onibus p) throws Exception {
        /* Define a SQL */
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT destino_onibus, tarifa_onibus, percursokm_onibus, percurso_minutos_onibus");
        sql.append("FROM tabela_onibus ");
        sql.append("WHERE destino_onibus LIKE ? ");
        sql.append("ORDER BY destino_onibus ");
        
        /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();

        /* Mapeamento objeto relacional */
        PreparedStatement comando = conn.prepareStatement(sql.toString());
        comando.setString(1, "%" + p.getDestino()+ "%");

        /* Executa a SQL e captura o resultado da consulta */
        ResultSet resultado = comando.executeQuery();

        /* Cria uma lista para armazenar o resultado da consulta */
        List<Onibus> lista = new ArrayList<Onibus>();

        /* Percorre o resultado armazenando os valores em uma lista */
        while (resultado.next()) {
            /* Cria um objeto para armazenar uma linha da consulta */
            Onibus linha = new Onibus();
            linha.setDestino(resultado.getString("destino_onibus"));
            linha.setTarifa(resultado.getDouble("tarifa_onibus"));
            linha.setPercursoKm(resultado.getDouble("percursokm_onibus"));
            linha.setPercursoMinutos(resultado.getDouble("percurso_minutos_onibus"));
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
    
    public void inserir(Onibus onibus) throws Exception {
    	/* Abre a conexão que criamos o retorno é armazenado na variavel conn */
        Connection conn = Conexao.abrir();
    	
    	   PreparedStatement p = conn.prepareStatement
    	   ("insert into onibus (destino_onibus, tarifa_onibus, percursokm_onibus, percurso_minutos_onibus) values (?,?,?,?)");
    	   p.setString(1, onibus.getDestino());
    	   p.setDouble(2, onibus.getTarifa());
    	   p.setDouble(3, onibus.getPercursoKm());
    	   p.setDouble(4, onibus.getPercursoMinutos());
    	   p.executeUpdate();
    	   p.close();
    	}
    public void deletar(Onibus onibus) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
    	   Connection conn = Conexao.abrir();
    	   PreparedStatement p = conn.prepareStatement("delete from onibus where destino_onibus = ?");
    	   p.setString(1, onibus.getDestino());
    	   p.executeUpdate();
    	   p.close();
    	}
    public void update(Onibus onibus) throws Exception {
    	   /* Abre a conexão que criamos o retorno é armazenado na variavel conn */
 	       Connection conn = Conexao.abrir();
    	   PreparedStatement p = 
    	   conn.prepareStatement
    	   ("update onibus set tarifa_onibus = ?, percursokm_onibus = ?, percurso_minutos_onibus = ? where destino_onibus = ?");
    	   
    	   p.setDouble(1, onibus.getTarifa());
    	   p.setDouble(2, onibus.getPercursoKm());
    	   p.setDouble(3, onibus.getPercursoMinutos());
    	   p.setString(4,onibus.getDestino() );
    	   p.executeUpdate();
    	   p.close();
    	}
 }


