package br.com.fwinternetbanking.model;

public class Gerente {
	
	private String nome;
	private String fone;
	private String celular;
	private String email;

	public Gerente(String nome, String fone, String celular, String email) {
		this.nome = nome;
		this.fone = fone;
		this.celular = celular;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
