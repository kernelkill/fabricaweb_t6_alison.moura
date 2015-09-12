package com.fabricadeprogramador.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabricadeprogramador.persistencia.entidade.Usuario;

//@WebFilter(dispatcherTypes={ DispatcherType.REQUEST}, urlPatterns={"/*"})
public class FiltroAutenticacao implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//Validar usuario
		
		//Pegar a sessao
		HttpSession session = req.getSession();
		
		//Peguei a url
		String url = req.getRequestURI();
		
		//pegar o usuario da sessão
		
		int loginjsp = url.lastIndexOf("/login.jsp");
		int autenticacontroller = url.lastIndexOf("/autenticaController");
		
		if(session.getAttribute("usuario")!=null || loginjsp>-1 || autenticacontroller>-1){
			
			//Liberar
			chain.doFilter(request, response);
			
		}else{
			
			//Volto o usuario para a tela de login
			resp.sendRedirect("login.jsp");
			
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
