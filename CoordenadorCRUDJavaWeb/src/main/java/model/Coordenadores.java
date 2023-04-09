	package model;


public class Coordenadores {

	private Integer id;

	private String nome;

	private Cursos cursos;

	private Periodos periodos;

	public Coordenadores() {
		super();
	}

	public Coordenadores(Integer id, String nome, Cursos cursos, Periodos periodos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cursos = cursos;
		this.periodos = periodos;
	}

	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	public Periodos getPeriodos() {
		return periodos;
	}

	public void setPeriodos(Periodos periodos) {
		this.periodos = periodos;
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
		return "Coordenadores [id=" + id + ", nome=" + nome + ", cursos=" + cursos + ", periodos=" + periodos + "]";
	}


}
