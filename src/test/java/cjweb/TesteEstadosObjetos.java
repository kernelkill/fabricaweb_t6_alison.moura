package cjweb;

import javax.persistence.EntityManager;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jpa.JPAUtil;

public class TesteEstadosObjetos {
	
	public static void main(String[] args) {
		
		Usuario usu = new Usuario();
		usu.setNome("Joana");
		usu.setLogin("maria");
		usu.setSenha("123");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuarioRetorno = em.find(Usuario.class, 3);
		
		System.out.println(usuarioRetorno.getNome());
		
		em.remove(usuarioRetorno);
		
		em.getTransaction().commit();
		em.close();
		
		
	}
	
	

}
