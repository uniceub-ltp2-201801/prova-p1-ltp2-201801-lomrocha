package model;

public class Disciplina {
	private int idDisciplina;
	private int idProfessor;
	private String nome;
	private String curso;
	private int cargaHoraria;

	public Disciplina(int idDisciplina, int idProfessor, String nome, String curso, int cargaHoraria) {
		this.idDisciplina = idDisciplina;
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.curso = curso;
		this.cargaHoraria = cargaHoraria;
	}

	public int getIdDisciplina() {
		return this.idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
