package edu.polimorfismo;

public class Funcionario {
	private long id;
	private String nome;
	private String matricula;
	private int faltasNoAno;
	private float ultimaNotaAvaliacao;
	private int qtdPremiosRecebidosAno;
	private boolean graduado;
	private String nomeFaculdade;
	private String nomeCurso;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public int getFaltasNoAno() {
		return faltasNoAno;
	}
	public void setFaltasNoAno(int faltasNoAno) {
		this.faltasNoAno = faltasNoAno;
	}
	
	public float getUltimaNotaAvaliacao() {
		return ultimaNotaAvaliacao;
	}
	public void setUltimaNotaAvaliacao(float ultimaNotaAvaliacao) {
		this.ultimaNotaAvaliacao = ultimaNotaAvaliacao;
	}
	
	public int getQtdPremiosRecebidosAno() {
		return qtdPremiosRecebidosAno;
	}
	public void setQtdPremiosRecebidosAno(int qtdPremiosRecebidosAno) {
		this.qtdPremiosRecebidosAno = qtdPremiosRecebidosAno;
	}
	
	public boolean isGraduado() {
		return graduado;
	}
	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}
	
	public String getNomeFaculdade() {
		return nomeFaculdade;
	}
	public void setNomeFaculdade(String nomeFaculdade) {
		this.nomeFaculdade = nomeFaculdade;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
}
