package cjweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ServiceSpringContext {

	@Qualifier("usuarioDAOJPA")
	@Autowired
	private UsuarioDAO dao;

//	@Autowired
//	private UsuarioService service;

	public ServiceSpringContext() {
	}

	@Test
	public void main() {
		System.out.println("main...");
	}

}
