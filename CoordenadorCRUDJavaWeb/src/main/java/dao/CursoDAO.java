package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Coordenadores;
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

	public void alterarCurso(Coordenadores coord, Cursos curso) {
		String query = "UPDATE cursos_coordenador SET id_curso = ? WHERE id_coordenador = ?";

		try {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, curso.getId());
			pst.setInt(2, coord.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
