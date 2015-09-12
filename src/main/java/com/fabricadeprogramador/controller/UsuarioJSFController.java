package com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.service.UsuarioService;
import com.fabricadeprogramador.service.exception.ServiceException;
import com.fabricadeprogramador.web.util.MensagemUtil;

@Controller
@ManagedBean
public class UsuarioJSFController {

	// Instância do UsuarioService
	@Autowired
	UsuarioService service;

	// Objeto do Bind
	private Usuario usuario;

	// Lista de usuarios
	private List<Usuario> usuarios;

	// Construtor
	public UsuarioJSFController() {
		// setando o usuário

	}

	@PostConstruct
	public void init() {
		// limpando o usuario
		setUsuario(new Usuario());

		// instanciando a lista de usuarios
		try {
			setUsuarios(service.buscarTodos());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	// Salvar
	public void salvar() {

		try {
			service.salvar(usuario);
			// pega mensagem de sucesso no MensagemUtil
			MensagemUtil.mensagemInfo("Salvo com sucesso!");
			// Limpar o usuario
			init();
		} catch (ServiceException e) {
			e.printStackTrace();
			// pega mensagem de erro no MensagemUtil
			MensagemUtil.mensagemErro("Erro ao salvar usuário!");
		}
	}

	public void excluir(Integer id) {
		try {
			service.excluir(id);
			MensagemUtil.mensagemInfo("Excluído com sucesso!");
			init();
		} catch (ServiceException e) {
			MensagemUtil.mensagemInfo("Erro ao excluir usuário!");
			e.printStackTrace();
		}
	}

	public void editar(Usuario usu) {
		if (!usu.getSenha().isEmpty()) {
			setUsuario(usu);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
