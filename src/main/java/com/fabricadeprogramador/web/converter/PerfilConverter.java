package com.fabricadeprogramador.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabricadeprogramador.persistencia.entidade.Perfil;
import com.fabricadeprogramador.service.PerfilService;
import com.fabricadeprogramador.service.exception.ServiceException;
import com.fabricadeprogramador.web.util.MensagemUtil;

@Component("perfilConverter")
public class PerfilConverter implements Converter{
	
	@Autowired
	PerfilService service;

	public PerfilConverter(){
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		try {
			Integer id = Integer.parseInt(value);
			return service.buscarPorId(id);
		} catch (NumberFormatException e){
			MensagemUtil.mensagemErro("Selecione um perfil");
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro("Erro ao converter o value para perfil");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null || !(value instanceof Perfil)){
			return "";
		}
		
		Perfil perfil = (Perfil)value;	
		
		return perfil.getId().toString();
	}

}
