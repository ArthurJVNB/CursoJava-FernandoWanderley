package br.com.testehibernate.model.cliente;

import java.util.ArrayList;

import br.com.testehibernate.model.E;

public class Cliente extends E<Cliente> {
	
	private String cpf;
	private Endereco endereco;
	private ArrayList<String> numeroContas;
	
	public Cliente(){}
	public Cliente(String cpf, String cep, String localNumero) {
		super(cpf);
		this.cpf = cpf;
		this.endereco = new Endereco(cep, localNumero);
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public ArrayList<String> getContas() {
		return numeroContas;
	}
	
	public void setContas(ArrayList<String> numeroContas) {
		this.numeroContas = numeroContas;
	}
}
