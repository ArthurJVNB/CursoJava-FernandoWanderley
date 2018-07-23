package br.com.fwinternetbanking.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Euller
 */
public class Cliente implements Comparable<Cliente> {

	public enum TipoCliente {
		Standard, Class, Vip;
	}

	private final String cpf;
	private String nome;
	private TipoCliente tipo;
	private Endereco endereco;

//	public Cliente(String nome, String cpf, TipoCliente tipo, String cep, String numero, String complemento) {
//		this.nome = nome;
//		this.cpf = cpf;
//		this.endereco = new Endereco(cep, numero, complemento);
//		this.tipo = tipo;
//	}

	public Cliente(String cpf, String nome, Endereco endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getCpf() {
		return this.cpf;
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
