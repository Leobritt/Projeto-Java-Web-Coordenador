package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Coordenadores;
import model.Cursos;
import model.Periodos;

public class CoordenadorDAO {
	Connection con = new Conexao().conectar();

	public ArrayList<Coordenadores> listaCoordenadores() {
		ArrayList<Coordenadores> listaCoordenadores = new ArrayList<>();
		Cursos curso = new Cursos();
		Periodos periodos = new Periodos();

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

				listaCoordenadores.add(
						new Coordenadores(idCoordenador, nomeCoordenador, new Cursos(idCurso, nomeCurso, siglaCurso),
								new Periodos(idPeriodo, diaPeriodo, horarioPeriodo)));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return listaCoordenadores;
	}

	public void inserirCoordenador(Coordenadores coord) {
		String query = "INSERT INTO coordenador (nome) VALUES (?)";

		try {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, coord.getNome());

			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void inserirCursoCoordenador(int idCoord, int idCurso) {
		String query = "INSERT INTO cursos_coordenador (id_coordenador, id_curso) VALUES (?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, idCoord);
			pst.setInt(2, idCurso);

			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void inserirPeriodoCoordenador(int idCoord, int idPeriodo) {
		String query = "INSERT INTO periodos_coordenador (id_periodo, id_coordenador) VALUES (?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(2, idCoord);
			pst.setInt(1, idPeriodo);

			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Coordenadores buscarCoordenadorPeloNome(String nome) {
		String query = "SELECT * FROM coordenador WHERE nome = ?";
		Coordenadores coord = new Coordenadores();

		try {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, nome);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String nomeCoordenador = rs.getString("nome");
				Integer idCoord = rs.getInt("id");
				coord.setNome(nomeCoordenador);
				coord.setId(idCoord);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return coord;

	}

	public void alterarCoordenador(Coordenadores coord) {
		String query = "UPDATE coordenador SET nome = ? WHERE id = ?";

		try {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, coord.getNome());
			pst.setInt(2, coord.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public Coordenadores listaCoordenadoresPeloId(int id) {
		
		Coordenadores coord = new Coordenadores();
		Cursos curso = new Cursos();
		Periodos periodos = new Periodos();

		String query = "SELECT c.id as idCoordenador, c.nome as NomeCoordenador, cu.id as idCurso, cu.nome as nomeCurso, cu.sigla as siglaCurso,p.id as idPeriodo, p.dia as diaPeriodo, p.horario as horarioPeriodo FROM coordenador c INNER JOIN cursos_coordenador cc on cc.id_coordenador = c.id INNER JOIN cursos cu on cu.id = cc.id_curso INNER JOIN periodos_coordenador pc on pc.id_coordenador = c.id INNER JOIN periodos p on p.id = pc.id_periodo WHERE c.id = ?";

		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
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
				
				coord.setCursos(new Cursos(idCurso, nomeCurso, siglaCurso));
				coord.setPeriodos(new Periodos(idPeriodo, diaPeriodo, horarioPeriodo));
				coord.setNome(nomeCoordenador);
				coord.setId(idCoordenador);
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return coord;
	}

}
