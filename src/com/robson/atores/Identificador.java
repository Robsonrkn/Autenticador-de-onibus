package com.robson.atores;

import com.robson.enums.Status;

public class Identificador {
	private Pessoa pessoa;
	private Status status;
	private long tempoPartida;
	private long tempoSaida;
	private int id;
	private double tarifaTotal;
	
	private static long tempo;
	
	public Identificador() {
		
	}
	public Identificador(Pessoa pessoa){
		this.pessoa  = pessoa;
	}
	
	public void verificador() {
	String test = pessoa.getStatus();
		if(test == "AUTORIZADO"){
			System.out.print("Autorizado. Boa Viagem !"); 
			Identificador.inicalizadorDeTempo();
			}else if(test == "PENDENTE"){
				System.out.print("Pendente, regularize suas pendencias, para não haver incomodos. Boa Viagem !");
				Identificador.inicalizadorDeTempo();
			}else if(test == "NAOAUTORIZADO") {
				System.out.print("Não Autorizado, revise o pagamento de suas outras viagens, ou entre em contato "
			+ "com a nossa central 000-000-000. Lamento o incomodo");
			}
	}

	public static void inicalizadorDeTempo() {
		tempo = System.currentTimeMillis();
	}
	
	public long getTempo() {
		return tempo;
	}
	public String getPessoa() {
		return pessoa.getNome();
	}

	public void setPessoa(String pessoa) {
		this.pessoa.setNome(pessoa);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public long getTempoPartida() {
		return tempoPartida;
	}
	public void setTempoPartida(long tempoParida) {
		this.tempoPartida = tempoParida;
	}
	public long getTempoSaida() {
		return tempoSaida;
	}
	public void setTempoSaida(long tempoSaida) {
		this.tempoSaida = tempoSaida;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTarifaTotal() {
		return tarifaTotal;
	}
	public void setTarifaTotal(double tarifaTotal) {
		this.tarifaTotal = tarifaTotal;
	}
}
