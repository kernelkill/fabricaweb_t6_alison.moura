package cjweb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJPA;
import com.fabricadeprogramador.persistencia.entidade.Usuario;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration( transactionManager="transactionManager",defaultRollback=true)
public class UsuarioDAOJPATeste {
	
	//@Qualifier("usuarioDAOJPA")
	@Autowired
	private UsuarioDAOJPA dao;

	public Usuario getUsuairo() {

		// Istanciando o usuário para ser persistido
		Usuario usu = new Usuario();
		//usu.setId(5);
		usu.setNome("Spring");
		usu.setLogin("spring");
		usu.setSenha("123");

		return usu;
	}
	
	@Test
	public void testeBuscarTodos(){
		//método buscarTodos do dao
		List<Usuario> usuarios = dao.buscarTodos();
		
		for(Usuario usu : usuarios){
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println(usu.toString());
			System.out.println("++++++++++++++++++++++++++++++++++++++");
		}
	}

}
