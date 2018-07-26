package br.com.testehibernate.model.clientes;

import java.util.ArrayList;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import br.com.testehibernate.model.E;

@Entity
@Table (name = "TB_CLIENTE")
public class Cliente extends E<Cliente> {
	
	private String cpf;
	private Endereco endereco;
	private ArrayList<String> numeroContas;
	
	public Cliente() {}
	
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
