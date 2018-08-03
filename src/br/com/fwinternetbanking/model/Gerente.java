package br.com.fwinternetbanking.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.fwinternetbanking.model.Cliente;

@Entity
@Table (name = "TB_GERENTE")
public class Gerente extends EntidadeGen {
	
	private String nome;
	private String fone;
	private String celular;
	private String email;
	
	@ManyToMany (mappedBy = "gerentes", targetEntity = Cliente.class)
	private Collection<Cliente> clientes;

	public Gerente(String nome, String fone, String celular, String email) {
		super(nome);
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

	public String getId() {
		return super.getId();
	}
}
