package com.robson.atores;
import com.robson.enums.*;;
public class Pessoa {
	
	private String nome;
	private int id;
	private String idade;
	private Status status;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, int id,String idade, Status status){
		this.nome = nome  ;
		this.id = id ;
		this.idade = idade;
		this.status = status ;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
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

