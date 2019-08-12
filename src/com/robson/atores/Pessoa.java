package com.robson.atores;
import java.text.ParseException;
import java.sql.Date;

import com.robson.enums.Status;
import com.robson.uteis.PadraoData;;
public class Pessoa {
	
	private String nome;
	private int id;
	private Date idade;
	private Status status;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String idade, Status status) throws ParseException{
		this.nome = nome  ;
		this.idade = new Date(PadraoData.StringParaDate(idade).getTime());
		this.status = status ;
	}

	public Date getIdade() {
		return idade;
	}

	public void setIdade(Date idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status.toString();
	}

	public void setStatus(String s) {
		
	if(s == "Autorizado")	
		this.status = Status.AUTORIZADO;
	else if(s == "Pendente")
		this.status = Status.PENDENTE;
	else if(s == "NaoAutorizado")
		this.status = Status.NAOAUTORIZADO;
	else
		this.status = Status.NAOAUTORIZADO;
		
		
	}
	
}

