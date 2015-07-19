package com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConexao() {
		try {
			
			Class.forName("org.postgresql.Driver");
			
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/cjweb", "postgres",
					"postgres");

		} catch (SQLException e) {
			throw new RuntimeException("Erro na conexão com o banco", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao recuperar a Classe Driver do Postgresql", e);
		}

	}

}
