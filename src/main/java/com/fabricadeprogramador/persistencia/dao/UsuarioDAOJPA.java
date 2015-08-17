package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jpa.JPAUtil;

@Repository("usuarioDAOJPA")
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public void cadastrar(Usuario usuario) {

		// Começar a transação
		em.getTransaction().begin();
		// Persisti o usuario
		em.persist(usuario);
		// commit
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(Usuario usuario) {

		em.getTransaction().begin();

		// merge
		em.merge(usuario);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void salvar(Usuario usuario) {
		em.getTransaction().begin();

		// merge
		em.merge(usuario);

		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void excluir(Integer id) {
		
		em.getTransaction().begin();
		
		//find
		Usuario usuarioRemove = em.find(Usuario.class, id);
		
		//remove
		em.remove(usuarioRemove);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public Usuario buscarPorId(Integer id) {
		
		Usuario usaurioRetorno = em.find(Usuario.class, id);
		
		return usaurioRetorno;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario autenticar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
