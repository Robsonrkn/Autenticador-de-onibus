package com.robson.atores;
import com.robson.conexao.Conexao;
import com.robson.dao.IdentificadorDAO;

public class Identificador {
	private Pessoa pessoa;
	private Onibus onibus;
	private long tempoPartida;
	private Identificador iden;
	private Long tempoSaida = null;
	private Double tarifaTotal = null;

	private static long tempo;
	
	public Identificador() {
		
	}
	public Identificador(Pessoa pessoa, Onibus onibus){
		this.pessoa  = pessoa;
		this.onibus = onibus;
	}
	
	public void verificador(Pessoa pessoa, Onibus onibus) {
	String test = pessoa.getStatus();
		if(test == "AUTORIZADO"){
			System.out.println("Autorizado. Boa Viagem !");
			
			this.iden = new Identificador(pessoa, onibus);
			IdentificadorDAO ideD = new IdentificadorDAO();
			
			try {
				ideD.inserir(iden);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			}else if(test == "PENDENTE"){
				System.out.println("Pendente, regularize suas pendencias, para não haver incomodos. Boa Viagem !");
				
				this.iden = new Identificador(pessoa, onibus);
				IdentificadorDAO ideD = new IdentificadorDAO();
				
				try {
					ideD.inserir(iden);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(test == "NAOAUTORIZADO") {
				System.out.println("Não Autorizado, revise o pagamento de suas outras viagens, ou entre em contato "
			+ "com a nossa central 000-000-000. Lamento o incomodo");
			}
	}
	public void saida() {
		Conexao con = new Conexao();
		try {
			con.abrir();
		}catch(Exception e) {
			System.out.print("Erro de conxao :"+e.getMessage());
		}
		
		IdentificadorDAO ideD = new IdentificadorDAO();
		this.iden.setTempoSaida(Identificador.inicalizadorDeTempo());
		long tempoTotal = ((iden.getTempoPartida() - iden.getTempoSaida())/1000)/60;
		double precoPorKm = this.onibus.getTarifa() / this.onibus.getPercursoMinutos();
		if(tempoTotal > (this.onibus.getPercursoMinutos() * 0.3) ) {
			this.iden.setTarifaTotal(tempoTotal * precoPorKm);
		}else {
			this.iden.setTarifaTotal(this.onibus.getTarifa()*0.3);
		}
		
		try {
			ideD.update(this.iden);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static long inicalizadorDeTempo() {
		tempo = System.currentTimeMillis();
		return tempo;
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
	public Onibus getOnibus() {
		return onibus;
	}
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	public String getNome() {
		return pessoa.getNome();
	}
	public long getTempoPartida() {
		return Identificador.inicalizadorDeTempo();
	}
	public void setTempoPartida(long tempoPartida) {
		this.tempoPartida = tempoPartida;
	}
	public Long getTempoSaida() {
		return tempoSaida;
	}
	public void setTempoSaida(long tempoSaida) {
		this.tempoSaida = tempoSaida;
	}
	public Double getTarifaTotal() {
		return tarifaTotal;
	}
	public void setTarifaTotal(Double tarifaTotal) {
		this.tarifaTotal = tarifaTotal;
	}
}
