package com.robson.principal;
import com.robson.conexao.Conexao;
public class OnibusFacil {

	public static void main(String[] args) {
		
		Conexao con = new Conexao();
		try {
			System.out.print("Conexao feita com sucesso!");
			con.abrir();
		}catch(Exception e) {
			System.out.print("Erro de conxao :"+e.getMessage());
		}
		
		
		
		
	}

}
