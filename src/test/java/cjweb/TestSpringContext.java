package cjweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fabricadeprogramador.persistencia.entidade.Usuario;

public class TestSpringContext {

	public static void main(String[] args) {
		
		System.out.println();

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/springbeans.xml");

		//UsuarioDAOJPA dao = (UsuarioDAOJPA) context.getBean("usuarioDAOJPA");
		
		//BasicDataSource dataSource = (BasicDataSource)context.getBean("dataSource");

		EntityManagerFactory emf = (EntityManagerFactory)context.getBean("entityManagerFactory");
		
		EntityManager em = emf.createEntityManager();
		
//		Usuario usu = new Usuario();
//		usu.setNome("Pepino");
//		usu.setLogin("pepi");
//		usu.setSenha("123");
//		
//		em.getTransaction().begin();
//		em.persist(usu);
//		em.getTransaction().commit();
//		em.close();
		
	}

}
