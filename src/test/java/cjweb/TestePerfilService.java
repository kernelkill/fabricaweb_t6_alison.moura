package cjweb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.fabricadeprogramador.persistencia.entidade.Perfil;
import com.fabricadeprogramador.service.PerfilService;
import com.fabricadeprogramador.service.exception.ServiceException;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestePerfilService {

	@Autowired
	PerfilService service;

	public Perfil getPerfil() {
		Perfil perfil = new Perfil();
		perfil.setId(3);
		perfil.setDescricao("VISITANTE");

		return perfil;
	}

	public TestePerfilService() {
	}

	//@Test
	public void testeCadastrar() {
		try {
			service.salvar(getPerfil());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testeAlterar() {
		try {
			service.salvar(getPerfil());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void testeRemover() {
		try {
			service.remover(getPerfil().getId());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testeBuscarPorId() {
		try {
			imprimirPerfil(service.buscarPorId(getPerfil().getId()));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	private void imprimirPerfil(Perfil perfil) {
		
		System.out.println("\tID: " + perfil.getId());
		System.out.println();
		System.out.println("\tDescrição: " + perfil.getDescricao());
		System.out.println();
		
	}

	@Test
	public void testeBuscarTodos() {
		try {
			imprimirList(service.buscarTodos());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	private void imprimirList(List<Perfil> lista) {

		System.out.println();
		System.out.println("Começo da Lista...\n");
		System.out.println();

		for (Perfil per : lista) {
			System.out.println("\tID: " + per.getId());
			System.out.println();
			System.out.println("\tDescrição: " + per.getDescricao());
			System.out.println();
		}
		
		System.out.println();
	}

}
