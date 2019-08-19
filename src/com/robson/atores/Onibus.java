package com.robson.atores;
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
