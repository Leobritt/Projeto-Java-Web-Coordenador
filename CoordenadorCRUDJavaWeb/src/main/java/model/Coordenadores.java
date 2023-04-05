package model;

import java.util.ArrayList;

public class Coordenadores {

	private Integer id;

	private String nome;

	private ArrayList<Cursos> listaCursos;

	private ArrayList<Periodos> listaPeriodos;

	public Coordenadores() {
		super();
	}

	public Coordenadores(Integer id, String nome, ArrayList<Cursos> listaCursos, ArrayList<Periodos> listaPeriodos) {
		super();
		this.id = id;
		this.nome = nome;
		this.listaCursos = listaCursos;
		this.listaPeriodos = listaPeriodos;
	}

	public ArrayList<Cursos> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(ArrayList<Cursos> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public ArrayList<Periodos> getListaPeriodos() {
		return listaPeriodos;
	}

	public void setListaPeriodos(ArrayList<Periodos> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Coordenadores [id=" + id + ", nome=" + nome + ", listaCursos=" + listaCursos + ", listaPeriodos="
				+ listaPeriodos + "]";
	}

}
