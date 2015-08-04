package com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class UsuarioDAOJDBC implements UsuarioDAO{
	
	//Pegar a conxao
	Connection con = ConexaoFactory.getConexao();
	
	public void cadastrar(Usuario usu) {
		
		// Segundo: construir o sql
		String sql = "INSERT INTO usuario (nome,login,senha) VALUES(?,?,md5(?))";

		// Terceiro:pegar o Statement
		try (PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
			// Quarto: executo o Statement
			preparador.execute();
			
			
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao cadastrar o usuário! ", ex); 
		}
		
	}
	
	public void alterar(Usuario usu){
		
		//Montar o sql
		String sql = "UPDATE usuario SET nome=?, login=?, senha=md5(?) WHERE id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql))
		{
			
			//Pegar o Statement
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			
			//Executando o sql
			preparador.execute();
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao alterar Usuário!", e);
		}
		
	}
	
	public void excluir(Integer id){
		
		//Montar o sql
		String sql = "DELETE FROM usuario WHERE id=?";
		
		//Pegando o statement
		try(PreparedStatement preparador = con.prepareStatement(sql)) 
		{
			//Setando o id
			preparador.setInt(1, id);
			
			//executar
			preparador.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao deletar!", e);
		}
		
	}
	
	public void salvar(Usuario usu){
		
		if(usu.getId()!=null && usu.getId()>0){
			//se existe, altere
			alterar(usu);
		}else{
			//senão, cadastre novo usuario
			cadastrar(usu);
		}
		
	}
	
	public Usuario buscarPorId(Integer id){
		
		//sql
		String sql = "SELECT * FROM usuario WHERE id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql);)
		{
			preparador.setInt(1, id);
			
			ResultSet result = preparador.executeQuery();
			
			if(result.next()){
				//instancia do usuario
				Usuario usuRetorno = new Usuario();
				
				//populando meu usuario de retorno
				usuRetorno.setNome(result.getString("nome"));
				usuRetorno.setLogin(result.getString("login"));
				usuRetorno.setSenha(result.getString("senha"));
				usuRetorno.setId(result.getInt("id"));
				
				//retorna meu usuario já preenchido
				return usuRetorno;
				
			}else{
				System.out.println("Usuário não existe!");
				return null;
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar por id!", e);
		}
		
	}
	
	public List<Usuario> buscarTodos(){
		
		
		//Montar sql
		String sql = "SELECT * FROM usuario order by nome desc";
		
		//Pegar Statement
		
		try(PreparedStatement preparador = con.prepareStatement(sql);) 
		{
			
			List<Usuario> listaRetorno = new ArrayList<Usuario>();
			
			ResultSet result = preparador.executeQuery();
			
			while(result.next()){
				
				//setar Usuario
				Usuario usu = new Usuario();
				
				usu.setNome(result.getString("nome"));
				usu.setLogin(result.getString("login"));
				usu.setSenha(result.getString("senha"));
				usu.setId(result.getInt("id"));
				
				//adicionar o usuário na lista
				listaRetorno.add(usu);
			}
			
			return listaRetorno;
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar todos", e);
		}
		
	}
	
	public Usuario autenticar(Usuario usu){
		
		//sql
		String sql = "SELECT * FROM usuario WHERE login=? and senha=md5(?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql))
		{
			
			preparador.setString(1, usu.getLogin());
			preparador.setString(2, usu.getSenha());
			
			ResultSet result = preparador.executeQuery();
			if(result.next()){
				
				Usuario retorno = new Usuario();
				retorno.setId(result.getInt("id"));
				retorno.setNome(result.getString("nome"));
				retorno.setLogin(result.getString("login"));
				retorno.setSenha(result.getString("senha"));
				
				return retorno;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao autenticar!", e);
		}
	}

}
















