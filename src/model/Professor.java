package model;

public class Professor {
	private int idProfessor;
	private String nome;
	private String dataNascimento;
	private String nomeMae;
	private int titulacao;
	
	public Professor(int idProfessor, String nome, String dataNascimento, String nomeMae, int titualacao) {
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nomeMae = nomeMae;
		this.titulacao = titualacao;
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

	public String getDataNascimento() {
		return this.dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public int getTitulacao() {
		return this.titulacao;
	}
	public void setTitulacao(int titualacao) {
		this.titulacao = titualacao;
	}
}
