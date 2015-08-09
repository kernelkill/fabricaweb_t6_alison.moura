package cjweb;

import javax.persistence.EntityManager;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJPA;
import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jpa.JPAUtil;

public class UsuarioDAOJPATeste {

	public static void main(String[] args) {

		// Pegar uma istancia de UsuarioDAOJPA
		UsuarioDAO dao = new UsuarioDAOJPA();

		// Istanciando o usuário para ser persistido
		Usuario usu = new Usuario();
		usu.setId(5);
		usu.setNome("");
		usu.setLogin("");
		usu.setSenha("");

		// cadastrar
		// dao.cadastrar(usu);

		// alterar
		// dao.alterar(usu);

		// excluir	
		// dao.excluir(5);
		
		//buscarPorId
		Usuario retorno = dao.buscarPorId(4);
		System.out.println(retorno.getNome());

	}

}
