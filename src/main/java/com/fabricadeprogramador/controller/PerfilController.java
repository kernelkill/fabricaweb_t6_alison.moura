package com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fabricadeprogramador.persistencia.entidade.Perfil;
import com.fabricadeprogramador.service.PerfilService;
import com.fabricadeprogramador.service.exception.ServiceException;
import com.fabricadeprogramador.web.util.MensagemUtil;

@Controller
@ManagedBean
public class PerfilController {

	//Service
	@Autowired
	PerfilService service;

	// Perfil
	private Perfil perfil;
	
	// lista de perfil
	private List<Perfil> perfils;

	public PerfilController() {
		setPerfil(new Perfil());
	}

	@PostConstruct
	public void init() {
		// Atualizar lista de todos
		try {
			perfils = service.buscarTodos();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro("Erro ao buscar todos os perfils");
			e.printStackTrace();
		}
		// Set perfil
		setPerfil(new Perfil());
	}

	// GETTERS E SETTERS
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> listaTodosPerfils) {
		this.perfils = listaTodosPerfils;
	}

}
