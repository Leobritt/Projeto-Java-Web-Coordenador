package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cursos;

public class CursoDAO {

	Connection con = new Conexao().conectar();

	public ArrayList<Cursos> listaCurso() {
		ArrayList<Cursos> listaCursos = new ArrayList();

		String query = "SELECT * FROM cursos";

		try {
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Integer idCurso = rs.getInt("id");
				String nomeCurso = rs.getString("nome");
				String siglaCurso = rs.getString("sigla");

				listaCursos.add(new Cursos(idCurso, nomeCurso, siglaCurso));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaCursos;
	}
}
