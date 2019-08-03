package com.robson.atores;
import com.robson.enums.*;;
public class Pessoa {
	
	private String nome;
	private int id;
	private Status status;
	
	public Pessoa(String nome, int id, Status status){
		this.nome = nome  ;
		this.id = id ;
		this.status = status ;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}

