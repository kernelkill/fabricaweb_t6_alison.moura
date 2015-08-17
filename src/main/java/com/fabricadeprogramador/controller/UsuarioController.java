package com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJDBC;
import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJPA;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@Controller
@WebServlet("/usucontroller")
public class UsuarioController extends HttpServlet {
	
	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuDao;

	protected HttpServletRequest req;
	protected HttpServletResponse resp;

	public UsuarioController() {
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Chamando o init...");
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Chamando o service...");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Chamando o método doGet");

		// Pegando os dados da requisição
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		// Instanciando o UsuarioDAO
		UsuarioDAOJDBC dao = new UsuarioDAOJDBC();
		// Instanciar o usuário
		Usuario usu = new Usuario();

		// Qual ação tomar
		if (acao.equalsIgnoreCase("cad")) {

			usu.setNome(nome);
			usu.setLogin(login);
			usu.setSenha(senha);

			dao.cadastrar(usu);

		} else if (acao.equalsIgnoreCase("alt")) {

			if (id != null && !id.isEmpty() && Integer.parseInt(id) > 0) {
				
				//Pegando o id da requisição
				String idAlterar = req.getParameter("id");
				
				//Buscar o Usuario referente ao idAlterar
				Usuario usuAlt = dao.buscarPorId(Integer.parseInt(idAlterar));
				
				//Colocar o objeto usuario na requisição 
				req.setAttribute("usuario", usuAlt);
				
				//Despachar a requisição para o formusu.jsp
				req.getRequestDispatcher("/WEB-INF/formusu.jsp").forward(req, resp);

			} else {
				// Mandar uma mensagem para o usuário
				resp.getWriter().print("<h1>ID incorreto!</h1>");
			}

		} else if (acao.equalsIgnoreCase("exc")) {

			dao.excluir(Integer.parseInt(id));

		} else if (acao.equalsIgnoreCase("form")) {

			//Instanciar um Usuario
			Usuario usuCad = new Usuario();
			usuCad.setId(0);
			usuCad.setNome("");
			usuCad.setLogin("");
			usuCad.setSenha("");
			
			//Colocar o usuCad como atributo da requisição
			req.setAttribute("usuario", usuCad);
			
			// resp.sendRedirect("WEB-INF/formusu.jsp");
			req.getRequestDispatcher("WEB-INF/formusu.jsp").forward(req, resp);

		} else if (acao.equalsIgnoreCase("list")) {

			// Carregar a lista de todos os usuários
			List<Usuario> listaUsuarios = dao.buscarTodos();

			// Colocar a lista dentro da requisição
			req.setAttribute("lista", listaUsuarios);

			// resp.sendRedirect("WEB-INF/listausuario.jsp");
			req.getRequestDispatcher("WEB-INF/listausuarios.jsp").forward(req,
					resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Chamando o método doPost");

		// Pega os dados da tela
		String acao = req.getParameter("acao");

		// Dao
		UsuarioDAOJDBC dao = new UsuarioDAOJDBC();

		// Usuario
		Usuario usu = new Usuario();

		if (acao != null && !acao.isEmpty()) {

			if (acao.equalsIgnoreCase("cad") || acao.equalsIgnoreCase("alt")) {

				String nome = req.getParameter("nome");
				String login = req.getParameter("login");
				String senha = req.getParameter("senha");
				String id = req.getParameter("id");

				if (id != null && !id.isEmpty() && Integer.parseInt(id) > 0) {

					// Instancia o Usuario
					usu.setId(Integer.parseInt(id));
					usu.setNome(nome);
					usu.setLogin(login);
					usu.setSenha(senha);

					// Instancia o UsuarioDAO
					dao.alterar(usu);

					// Fazer o Response
					resp.getWriter().print(
							"<h1>Usuário: " + usu.getNome()
									+ " foi alterado com sucesso!</h1>");
					resp.sendRedirect("usucontroller?acao=list");

				} else {

					// Instancia o Usuario
					usu.setNome(nome);
					usu.setLogin(login);
					usu.setSenha(senha);

					// Instancia o UsuarioDAO
					dao.cadastrar(usu);

					// Fazer o Response
					resp.getWriter().print(
							"<h1>Usuário: " + usu.getNome()
									+ " foi cadastrado com sucesso!</h1>");
					
					resp.sendRedirect("usucontroller?acao=list");
					
				}
			} else if (acao.equalsIgnoreCase("exc")) {

				// Pegando os parametros
				String[] ids = req.getParameterValues("id");

				// Percorrendo a lista
				for (String id : ids) {

					// Deleta o usuario com o id da vez
					dao.excluir(Integer.parseInt(id));

				}

				resp.sendRedirect("usucontroller?acao=list");

			}

		}else{
			resp.getWriter().print("Essa requisição não é válida");
		}

	}

	@Override
	public void destroy() {
		System.out.println("Chamando o destroy...");
		super.destroy();
	}

}
