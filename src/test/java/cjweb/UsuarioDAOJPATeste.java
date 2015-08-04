package cjweb;

import javax.persistence.EntityManager;
import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jpa.JPAUtil;

public class UsuarioDAOJPATeste{
	
	public static void main(String[] args) {
		
		//Istanciando o usuário para ser persistido
		Usuario usu = new Usuario();
		usu.setNome("Joabe");
		usu.setLogin("jojo");
		usu.setSenha("123");
		
		//cadastrar
		testeCadastrar(usu);
		
		
	}
	
	public static void testeCadastrar(Usuario usu){
		
		//Pegar o entityManager
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		//começarmos a transação
		entityManager.getTransaction().begin();
		
		//fazermos as ações
		entityManager.persist(usu);
		
		//commitarmos as ações
		entityManager.getTransaction().commit();
		
		//fechar a o entityManager
		entityManager.close();
		
		
	}

}
