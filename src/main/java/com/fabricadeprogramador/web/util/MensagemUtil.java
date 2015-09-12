package com.fabricadeprogramador.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	// info
	public static void mensagemInfo(String mensagem) {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
	}

	// warning
	public static void mensagemAviso(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null));
	}

	// error
	public static void mensagemErro(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
	}

}
