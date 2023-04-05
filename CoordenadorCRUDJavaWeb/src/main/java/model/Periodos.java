package model;

public class Periodos {

	private Integer id;

	private String dia;

	private String horario;
	
	
	
	public Periodos() {
		super();
	}

	public Periodos(Integer id, String dia, String horario) {
		super();
		this.id = id;
		this.dia = dia;
		this.horario = horario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Periodos [id=" + id + ", dia=" + dia + ", horario=" + horario + "]";
	}

}
