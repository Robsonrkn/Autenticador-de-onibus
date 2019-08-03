package com.robson.enums;

public enum Status {
	AUTORIZADO("Autorizado"), PENDENTE("Pendente"), NAOAUTORIZADO("NãoAutorizado");
	
	private String situacao ;
	Status(String s){
		situacao = s;
	}
	public String getStatus() {
		return situacao;
	}
	public void setStatus(String i) {
		this.situacao = i;
	}
}

