package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Coordenadores;
import model.Cursos;
import model.Periodos;

public class CoordenadorDAO {
	Connection con = new Conexao().conectar();

	public ArrayList<Coordenadores> listaCoordenadores() {
		ArrayList<Coordenadores> listaCoordenadores = new ArrayList<>();
		ArrayList<Cursos> listaCurso = new ArrayList<>();
		ArrayList<Periodos> listaPeriodos = new ArrayList<>();

		String query = "SELECT c.id as idCoordenador, c.nome as NomeCoordenador, cu.id as idCurso, cu.nome as nomeCurso, cu.sigla as siglaCurso,p.id as idPeriodo, p.dia as diaPeriodo, p.horario as horarioPeriodo FROM coordenador c INNER JOIN cursos_coordenador cc on cc.id_coordenador = c.id INNER JOIN cursos cu on cu.id = cc.id_curso INNER JOIN periodos_coordenador pc on pc.id_coordenador = c.id INNER JOIN periodos p on p.id = pc.id_periodo;";

		try {
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Integer idCoordenador = rs.getInt("idCoordenador");
				String nomeCoordenador = rs.getString("nomeCoordenador");
				Integer idCurso = rs.getInt("idCurso");
				String nomeCurso = rs.getString("nomeCurso");
				String siglaCurso = rs.getString("siglaCurso");
				Integer idPeriodo = rs.getInt("idPeriodo");
				String diaPeriodo = rs.getString("diaPeriodo");
				String horarioPeriodo = rs.getString("horarioPeriodo");

				listaCurso.add(new Cursos(idCurso, nomeCurso, siglaCurso));
				listaPeriodos.add(new Periodos(idPeriodo, diaPeriodo, horarioPeriodo));

				listaCoordenadores.add(new Coordenadores(idCoordenador, nomeCoordenador, listaCurso, listaPeriodos));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return listaCoordenadores;
	}

}
