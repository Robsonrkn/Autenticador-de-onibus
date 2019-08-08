package com.robson.atores;

import com.robson.enums.Status;

public class Onibus {
	private String destino;
	private Double percursoMetros;
	private Double tarifa;
	private Double percursoMinutos;
	
	public Onibus() {
		
	}
	public Onibus(String destino,Double tarifa ,Double percursoKm, Double percursoMinutos) {
		super();
		this.destino = destino;
		this.percursoMetros = percursoKm;
		this.tarifa = tarifa;
		this.percursoMinutos = percursoMinutos;
	}
	
	public void precoPassagem() {
		Double precoFinal = 0.0;
		Double metrosPorMinuto = this.percursoMetros / this.percursoMinutos;
		Double centavosPorMinuto = this.tarifa / this.percursoMinutos;
		Double metrosPorMinutoMinimo = metrosPorMinuto * 0.3;
		
		//logica a ser resolvida.
		//long tempoGasto = (saida() - ide.getTempo()) / 60000;
		//precoFinal = (tempoGasto * metrosPorMinuto) * centavosPorMinuto;
		
		System.out.print("Total da viagem: " + precoFinal);
	}
	public long saida() {
		long tempoFinal= System.currentTimeMillis();
		return tempoFinal;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getPercursoKm() {
		return percursoMetros;
	}
	public void setPercursoKm(Double percursoKm) {
		this.percursoMetros = percursoKm;
	}
	public Double getTarifa() {
		return tarifa;
	}
	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}
	public Double getPercursoMinutos() {
		return percursoMinutos;
	}
	public void setPercursoMinutos(Double percursoMinutos) {
		this.percursoMinutos = percursoMinutos;
	}
	
	
}
