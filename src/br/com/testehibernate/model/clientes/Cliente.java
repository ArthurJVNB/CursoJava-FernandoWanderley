package br.com.testehibernate.model.clientes;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import br.com.testehibernate.model.E;

@Entity
@Table (name = "TB_CLIENTE")
public class Cliente extends E<Cliente> {
	
	@Id
	@Column (name = "CPF")
	private String cpf;
	
	@Column (name = "NOME")
	private String nome;
	
	// TODO passar para a tabela TB_ENDERECO
	private Endereco endereco;
	
	// TODO consultar (?) a tabela TB_CONTA, na coluna TB_CLIENTE_CPF
	private ArrayList<String> numeroContas;
	
	public Cliente() {}
	
	public Cliente(String cpf, String nome, String cep, String localNumero) {
		super(cpf);
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = new Endereco(cpf, cep, localNumero);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
