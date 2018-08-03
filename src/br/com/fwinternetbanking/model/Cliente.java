package br.com.fwinternetbanking.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Euller
 */

@Entity
@Table(name = "TB_CONTA")
public class Cliente extends EntidadeGen implements Comparable<Cliente>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5485266271521636961L;

	@Id
	@ManyToMany(targetEntity = Gerente.class)
	@JoinTable(name = "TB_GERENTES_CLIENTE", joinColumns = {
			@JoinColumn(name = "TB_CLIENTE_CPF") }, inverseJoinColumns = { @JoinColumn(name = "TB_GERENTE_ID") })
	@JoinColumn(name = "CPF")
	private String cpf;

	@JoinColumn(name = "NOME")
	private String nome;

	private TipoCliente tipo;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Endereco endereco;

	public Cliente() {
	}

	public Cliente(String cpf, String nome, TipoCliente tipo, String cep, String numero, String complemento) {
		super(cpf);
		this.cpf = cpf;
		this.nome = nome;
		this.tipo = tipo;
		this.endereco = new Endereco(cpf, cep, numero, complemento);
	}

	public String getCpf() {
		return this.cpf;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", tipo=" + tipo + ", endereco=" + endereco + "]";
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCliente getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int compareTo(Cliente c) {

		return this.getCpf().compareTo(c.getCpf());
	}

}
