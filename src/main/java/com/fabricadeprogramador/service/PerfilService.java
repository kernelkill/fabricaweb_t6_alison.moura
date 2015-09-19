package com.fabricadeprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fabricadeprogramador.persistencia.dao.PerfilDAO;
import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Perfil;
import com.fabricadeprogramador.service.exception.ServiceException;

@Service
public class PerfilService {

	@Qualifier("perfilDAOJPA")
	@Autowired
	PerfilDAO dao;

	public PerfilService() {
	}

	public void cadastrar(Perfil perfil) throws ServiceException {
		try {
			dao.cadastrar(perfil);
		} catch (DAOException e) {
			throw new ServiceException("Erro no cadastro de perfil: ", e);
		}
	}

	public void alterar(Perfil perfil) throws ServiceException {
		try {
			dao.alterar(perfil);
		} catch (DAOException e) {
			throw new ServiceException("Erro na alteração de perfil: ", e);
		}
	}

	public void salvar(Perfil perfil) throws ServiceException {
		try {
			dao.salvar(perfil);
		} catch (DAOException e) {
			throw new ServiceException("Erro ao salvar perfil: ", e);
		}
	}

	public void remover(Integer id) throws ServiceException {
		try {
			dao.excluir(id);
		} catch (DAOException e) {
			throw new ServiceException("Erro ao remover perfil: ", e);
		}
	}

	public Perfil buscarPorId(Integer id) throws ServiceException {
		try {
			return dao.buscarPorId(id);
		} catch (DAOException e) {
			throw new ServiceException("Erro na buscar por id de perfil: ", e);
		}
	}

	public List<Perfil> buscarTodos() throws ServiceException {
		try {
			return dao.buscarTodos();
		} catch (DAOException e) {
			throw new ServiceException("Erro na busca de todos os perfils: ", e);
		}
	}

}
