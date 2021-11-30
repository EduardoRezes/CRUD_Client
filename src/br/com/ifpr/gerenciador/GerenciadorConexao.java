package br.com.ifpr.gerenciador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
	private static Connection conexao;

	public static Connection pegarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexao = DriverManager.getConnection("jdbc:mysql://localhost/dbCrudCliente", "root", "root");
		return(conexao);
	}
}
