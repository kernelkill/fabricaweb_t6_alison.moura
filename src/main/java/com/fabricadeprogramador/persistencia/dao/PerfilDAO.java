package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Perfil;

public interface PerfilDAO {
	
	void cadastrar(Perfil perfil) throws DAOException;
	void alterar(Perfil perfil) throws DAOException;
	void salvar(Perfil perfil) throws DAOException;
	void excluir(Integer id) throws DAOException;
	Perfil buscarPorId(Integer id) throws DAOException;
	List<Perfil> buscarTodos() throws DAOException;

}
