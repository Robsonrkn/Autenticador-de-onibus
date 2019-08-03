package com.robson.atores;

import com.robson.enums.Status;

public class Identificador {
	private Pessoa pessoa;
	private Status status;
	private static long tempo;
	public Identificador(Pessoa pessoa){
		pessoa = this.pessoa;
	}
	
	public void verificador() {
	/*O correto seria ter uma pessoa em um banco de dados e ser acessada diretamente pelo verificador
	Neste caso usamos diretamente, o que não é o mais correto.
	*/
	Pessoa robson = new Pessoa("Robson", 01, Status.AUTORIZADO);
	Status test = robson.getStatus();
	//.
		switch(test) {
	case AUTORIZADO : {System.out.print("Autorizado. Boa Viagem !"); Identificador.inicalizadorDeTempo();}break;
	case PENDENTE : {System.out.print("Pendente, regularize suas pendencias, para não haver incomodos. Boa Viagem !");
			Identificador.inicalizadorDeTempo();}break;
	case NAOAUTORIZADO : System.out.print("Não Autorizado, revise o pagamento de suas outras viagens, ou entre em contato "
			+ "com a nossa centra 000-000-000. Lamento o incomodo");	
	}
	}
	public static void inicalizadorDeTempo() {
		tempo = System.currentTimeMillis();
	}
	public long getTempo() {
		return tempo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
