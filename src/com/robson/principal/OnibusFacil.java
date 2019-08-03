package com.robson.principal;
import com.robson.atores.*;
import com.robson.enums.Status;
public class OnibusFacil {

	public static void main(String[] args) {
		
		Pessoa robson = new Pessoa("Robson", 01, Status.AUTORIZADO);
		Identificador ide = new Identificador(robson);
		ide.verificador();
		
		Onibus oni = new Onibus("Cotia-Portao", 18.600,5.30,50.0);
		
		
	}

}
