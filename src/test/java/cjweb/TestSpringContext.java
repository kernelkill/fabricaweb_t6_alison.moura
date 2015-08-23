package cjweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJPA;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestSpringContext {
	
	@Autowired
	UsuarioDAOJPA dao;
	
	@Test
	public void testCadastrar(){
		
		Usuario usuario = new Usuario();
		usuario.setNome("Abacaxi");
		usuario.setLogin("acabaxi");
		usuario.setSenha("1234444");
		
		dao.cadastrar(usuario);
		
	}

	// public static void main(String[] args) {

	// System.out.println();

	// ClassPathXmlApplicationContext context = new
	// ClassPathXmlApplicationContext(
	// "file:src/main/webapp/WEB-INF/springbeans.xml");

	// UsuarioDAOJPA dao = (UsuarioDAOJPA) context.getBean("usuarioDAOJPA");

	// BasicDataSource dataSource =
	// (BasicDataSource)context.getBean("dataSource");

	// EntityManagerFactory emf =
	// (EntityManagerFactory)context.getBean("entityManagerFactory");
	//
	// EntityManager em = emf.createEntityManager();
	//
	// UsuarioDAOJPA dao = (UsuarioDAOJPA)context.getBean("usuarioDAOJPA");
	//
	// Usuario usu = new Usuario();
	// usu.setNome("Batata");
	// usu.setLogin("batpotato");
	// usu.setSenha("123");
	//
	// dao.cadastrar(usu);

	// }

}
