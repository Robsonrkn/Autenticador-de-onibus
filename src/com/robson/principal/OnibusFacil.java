package com.robson.principal;
import java.text.ParseException;

import com.robson.atores.Identificador;
import com.robson.atores.Onibus;
import com.robson.atores.Pessoa;
import com.robson.conexao.Conexao;
import com.robson.dao.OnibusDAO;
import com.robson.dao.PessoaDAO;
import com.robson.enums.Status;
public class OnibusFacil {

	public static void main(String[] args) throws ParseException {
		
		Conexao con = new Conexao();
		try {
			con.abrir();
			System.out.println("Conexao feita com sucesso!");
		}catch(Exception e) {
			System.out.print("Erro de conxao :"+e.getMessage());
		}
		Pessoa p = new Pessoa("Ana Luiza", "3/2/1999", Status.AUTORIZADO);
		PessoaDAO pd = new PessoaDAO();
	
		
		Onibus oni = new Onibus("Caucaia", 5.0, 15.3, 43.0);
		OnibusDAO oniD = new OnibusDAO();

		Identificador iden = new Identificador(p, oni);
		iden.verificador(p, oni);
		
		iden.saida();
		
		
		
}

}
