package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Coordenadores;
import model.Cursos;
import model.Periodos;

public class PeriodoDAO {
	Connection con = new Conexao().conectar();

	public ArrayList<Periodos> listaPeriodos() {
		ArrayList<Periodos> listaPeriodos = new ArrayList();

		try {
			String query = "SELECT * FROM periodos";
			
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Integer idPeriodo = rs.getInt("id");
				String diaPeriodo = rs.getString("dia");
				String horarioPeriodo = rs.getString("horario");
				
				listaPeriodos.add(new Periodos(idPeriodo, diaPeriodo, horarioPeriodo));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaPeriodos;
	}
	public void alterarPeriodo(Coordenadores coord, Periodos per) {
		String query = "UPDATE periodos_coordenador SET id_periodo = ? WHERE id_coordenador = ?";

		try {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, per.getId());
			pst.setInt(2, coord.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
