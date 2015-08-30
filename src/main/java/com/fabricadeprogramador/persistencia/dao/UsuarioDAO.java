package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@Repository
public interface UsuarioDAO {
	
	void cadastrar(Usuario usuario) throws DAOException;
	void alterar(Usuario usuario) throws DAOException;
	void salvar(Usuario usuario) throws DAOException;
	void excluir(Integer id) throws DAOException;
	Usuario buscarPorId(Integer id) throws DAOException;
	Usuario buscarPorLogin(String login) throws DAOException;
	List<Usuario> buscarTodos() throws DAOException;
	Usuario autenticar(Usuario usuario) throws DAOException;

}
