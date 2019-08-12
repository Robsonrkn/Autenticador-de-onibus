package com.robson.principal;
import java.text.ParseException;

import com.robson.atores.Identificador;
import com.robson.atores.Pessoa;
import com.robson.conexao.Conexao;
import com.robson.dao.IdentificadorDAO;
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
		Pessoa p1 = new Pessoa("Robson", "30/09/1996", Status.AUTORIZADO);
		PessoaDAO pDao = new PessoaDAO();
		
		Identificador ide = new Identificador(p1);
		IdentificadorDAO iDao = new IdentificadorDAO();

		
		
		
		
}

}
