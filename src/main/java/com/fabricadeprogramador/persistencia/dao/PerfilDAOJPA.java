package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Perfil;

@Repository("perfilDAOJPA")
public class PerfilDAOJPA implements PerfilDAO {

	@PersistenceContext
	EntityManager em;

	public PerfilDAOJPA() {
	}

	@Transactional
	public void cadastrar(Perfil perfil) throws DAOException {
		try {
			em.persist(perfil);
		} catch (Exception e) {
			throw new DAOException("Erro ao cadastrar Perfil", e);
		}
	}

	@Transactional
	public void alterar(Perfil perfil) throws DAOException {
		try {
			em.merge(perfil);
		} catch (Exception e) {
			throw new DAOException("Erro ao alterar Perfil", e);
		}	}

	@Transactional
	public void salvar(Perfil perfil) throws DAOException {
		try {
			em.merge(perfil);
		} catch (Exception e) {
			throw new DAOException("Erro ao salvar Perfil", e);
		}
	}

	@Transactional
	public void excluir(Integer id) throws DAOException {

		try {
			em.remove(em.find(Perfil.class, id));
		} catch (NoResultException e) {
			throw new DAOException("Nenhum resultado encontrado!", e);
		} catch (Exception e) {
			throw new DAOException("Erro ao excluir Perfil", e);
		}
	}

	public Perfil buscarPorId(Integer id) throws DAOException {
		try {
			return em.find(Perfil.class, id);
		} catch (NoResultException e) {
			throw new DAOException("Nenhum resultado encontrado!", e);
		} catch (Exception e) {
			throw new DAOException("Erro ao buscarPorId Perfil", e);
		}
	}

	public List<Perfil> buscarTodos() throws DAOException {
		try {
			// Monta um sql em String
			String sql = "select p from Perfil as p order by id asc";

			// EntityManager cria a query
			Query query = em.createQuery(sql);

			// Quarda o retorno dentro de uma lista
			List<Perfil> perfils = query.getResultList();

			return perfils;
		} catch (NoResultException e) {
			throw new DAOException("Nenhum resultado encontrado!");
		} catch (Exception e) {
			throw new DAOException("Erro ao salvar usuário: ", e);
		}
	}

}
