package com.fabricadeprogramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.service.exception.ServiceException;

@Service
public class UsuarioService {
	
	@Qualifier("usuarioDAOJPA")
	@Autowired
	private UsuarioDAO dao;
	
	
	public void salvar(Usuario usu) throws ServiceException{
		try {
			
			//verificar se o login já existe
			Usuario usuarioExistente = dao.buscarPorLogin(usu.getLogin());
			
			if(usuarioExistente!=null){
				//se o login já estiver sendo usado, lança-se uma exceção
				throw new ServiceException("Login já existe!");
			}
			//salvar usuario
			dao.salvar(usu);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public void excluir(Integer id){
		try {
			dao.excluir(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
