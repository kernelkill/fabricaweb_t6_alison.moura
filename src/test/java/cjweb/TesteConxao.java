package cjweb;

import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class TesteConxao {

	public static void main(String[] args) {
		
		testaConexao();
		System.out.println("Conectado com sucesso!");

	}
	
	public static void testaConexao(){
		ConexaoFactory.getConexao();
	}

}
