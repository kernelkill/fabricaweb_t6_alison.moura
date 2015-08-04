package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import com.fabricadeprogramador.persistencia.entidade.Usuario;

public interface UsuarioDAO {
	
	void cadastrar(Usuario usuario);
	void alterar(Usuario usuario);
	void salvar(Usuario usuario);
	void excluir(Integer id);
	Usuario buscarPorId(Integer id);
	List<Usuario> buscarTodos();
	Usuario autenticar(Usuario usuario);

}
