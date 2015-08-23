package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jpa.JPAUtil;

@Repository("usuarioDAOJPA")
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public void cadastrar(Usuario usuario) {
		// Persisti o usuario
		em.persist(usuario);
	}

	@Transactional
	public void alterar(Usuario usuario) {
		// merge
		em.merge(usuario);
	}

	@Transactional
	public void salvar(Usuario usuario) {
		// merge
		em.merge(usuario);
	}

	@Transactional
	public void excluir(Integer id) {
		
		//find
		Usuario usuarioRemove = em.find(Usuario.class, id);
		
		//remove
		em.remove(usuarioRemove);

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
