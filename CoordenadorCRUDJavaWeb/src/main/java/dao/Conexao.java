package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
	private String url = "jdbc:postgresql://localhost:5432/tedweb";
	private String usuario = "postgres";
	private String senha = "postgres";
	private Connection con;

	public Connection conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println(con);
			return con;
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

}