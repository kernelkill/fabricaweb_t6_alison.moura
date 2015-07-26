package com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@WebServlet("/autenticaController")
public class AutenticaController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Instanciar o UsuarioDAO
	UsuarioDAO dao = new UsuarioDAO();

	public AutenticaController(){
		
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//pega a acao da requisição
		String acao = req.getParameter("acao");
		
		if(acao.equalsIgnoreCase("pagina-principal")){
			
			//redirecionar para index.jsp
			resp.sendRedirect("/WEB-INF/index.jsp");
			
		}else if(acao.equalsIgnoreCase("sair")){
			
			//Invalidar a sessão
			HttpSession session = req.getSession(false);
			session.invalidate();
			
			//voltar para a tela de login.jsp
			resp.sendRedirect("login.jsp");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Validar usuário
		//Peguei os parametros "login" e "senha"
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		//Instanciar um Usuário
		Usuario usuAutenticar = new Usuario();
		usuAutenticar.setLogin(login);
		usuAutenticar.setSenha(senha);
		
		//Chamar o método autenticar do dao
		Usuario usuAutenticado = dao.autenticar(usuAutenticar);
		
		//Verificar se o usuAutenticado é nulo ou não
		if(usuAutenticado!=null){
			
			//Criar usa sessão para o usuário autenticado
			HttpSession session = req.getSession();
			
			//Colocar usuário validado dentro da sessão
			session.setAttribute("usuario", usuAutenticado);
			
			//Setar um tempo limite
			session.setMaxInactiveInterval(300);
			
			//Se o usuário for realmente autenticado -> manda para o index.jsp
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
			
		}else{
			
			//Se o usuário não for realmente autenticado -> manda para o login.jsp
			resp.sendRedirect("login.jsp");
			
		}
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}
