package cjweb;

import java.util.List;
import java.util.Scanner;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJDBC;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

public class TesteUsuarioDAOJDBCTeste {

	public static void main(String[] args) {

		// Instancia do scanner
		Scanner teclado = new Scanner(System.in);
		// Instancia do UsuarioDAO
		UsuarioDAOJDBC dao = new UsuarioDAOJDBC();
		// Instancia do Usuario
		Usuario usu = new Usuario();

		testaCadastar(teclado, usu, dao);
		// testeAlterar(teclado, usu, dao);
		// testeExcluir(teclado, dao);
		// testeSalvar(teclado, usu, dao);
		// testeBuscaPorId(teclado, dao);
		//testeBuscaTodos(dao);
		//testeAutenticar(dao, usu, teclado);

		// no final...
		teclado.close();

	}

	public static void testaCadastar(Scanner teclado, Usuario usu,
			UsuarioDAOJDBC dao) {

		System.out.println("Nome do usuário: ");
		usu.setNome(teclado.nextLine());

		System.out.println("Login do usuário: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Senha do usuário: ");
		usu.setSenha(teclado.nextLine());

		// Invocar o método cadastrarUsuario
		dao.cadastrar(usu);
		System.out.println("Cadastrar com sucesso!");

	}

	public static void testeAlterar(Scanner teclado, Usuario usu, UsuarioDAOJDBC dao) {

		System.out.println("Id do usuário: ");
		usu.setId(teclado.nextInt());
		teclado.nextLine();

		System.out.println("Nome do usuário: ");
		usu.setNome(teclado.nextLine());

		System.out.println("Login do usuário: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Senha do usuário: ");
		usu.setSenha(teclado.nextLine());

		// Invocar o método cadastrarUsuario
		dao.alterar(usu);
		System.out.println("Alterado com sucesso!");

	}

	public static void testeExcluir(Scanner teclado, UsuarioDAOJDBC dao) {

		System.out.println("Digite o ID do usuário a ser excluído: ");
		Integer id = teclado.nextInt();

		// Invocar o método excluir
		dao.excluir(id);
		System.out.println("Usuário com o id= " + id
				+ ", excluído com sucesso!");

	}

	public static void testeSalvar(Scanner teclado, Usuario usu, UsuarioDAOJDBC dao) {

		System.out.println("Id do usuário: ");
		usu.setId(teclado.nextInt());
		teclado.nextLine();

		System.out.println("Nome do usuário: ");
		usu.setNome(teclado.nextLine());

		System.out.println("Login do usuário: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Senha do usuário: ");
		usu.setSenha(teclado.nextLine());

		// Invocar o método cadastrarUsuario
		dao.salvar(usu);
		System.out.println("Salvo com sucesso!");

	}

	public static void testeBuscaPorId(Scanner teclado, UsuarioDAOJDBC dao) {

		System.out.println("Digite o ID do usuário a ser buscado: ");
		Integer id = teclado.nextInt();

		// Invocar o método excluir
		Usuario usuRetornado = dao.buscarPorId(id);

		if (usuRetornado != null) {
			// Imprimindo o usuario de retorno
			System.out.println("Nome: " + usuRetornado.getNome());
			System.out.println("Login: " + usuRetornado.getLogin());
			System.out.println("Senha: " + usuRetornado.getSenha());
			System.out.println("ID: " + usuRetornado.getId());

		}
	}

	public static void testeBuscaTodos(UsuarioDAOJDBC dao) {

		// invocar o metodo buscaTodos
		List<Usuario> lista = dao.buscarTodos();

		// Imprimir
		for (Usuario usu : lista) {

			System.out.println();
			System.out.println("Nome: " + usu.getNome());
			System.out.println("Login: " + usu.getLogin());
			System.out.println("Senha: " + usu.getSenha());
			System.out.println("ID: " + usu.getId());
			System.out.println();

		}
	}

	public static void testeAutenticar(UsuarioDAOJDBC dao, Usuario usu,
			Scanner teclado) {

		System.out.println("Login do usuário: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Senha do usuário: ");
		usu.setSenha(teclado.nextLine());
		
		Usuario retornado = dao.autenticar(usu);
		// Imprimir

		System.out.println();
		System.out.println("Nome: " + retornado.getNome());
		System.out.println("Login: " + retornado.getLogin());
		System.out.println("Senha: " + retornado.getSenha());
		System.out.println("ID: " + retornado.getId());
		System.out.println();

	}

}
