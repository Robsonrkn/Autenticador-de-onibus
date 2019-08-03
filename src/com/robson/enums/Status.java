package com.robson.enums;

public enum Status {
	AUTORIZADO(0), PENDENTE(1), NAOAUTORIZADO(2);
	
	private int valor = 0;
	Status(int i){
		valor = i;
	}
	public int getStatus() {
		return valor;
	}
	public void setStatus(int valor) {
		this.valor = valor;
	}
}

