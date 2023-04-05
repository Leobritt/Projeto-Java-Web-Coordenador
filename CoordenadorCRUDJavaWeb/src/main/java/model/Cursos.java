package model;

public class Cursos {

	private Integer id;

	private String nome;

	private String sigla;

	public Cursos() {
		super();
	}

	public Cursos(Integer id, String nome, String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Cursos [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}

}
