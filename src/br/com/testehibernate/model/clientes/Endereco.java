package br.com.testehibernate.model.clientes;

public class Endereco {
	// TODO fazer a preparacao para o Hibernate
	private String cpfCliente;
	private String cep;
	private String localNumero;
	
	public Endereco() {}
	
	public Endereco(String cpfCliente, String cep, String localNumero) {
		this.cpfCliente = cpfCliente;
		this.cep = cep;
		this.localNumero = localNumero;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	protected String getCep() {
		return cep;
	}
	protected void setCep(String cep) {
		this.cep = cep;
	}
	
	protected String getLocalNumero() {
		return localNumero;
	}
	protected void setLocalNumero(String localNumero) {
		this.localNumero = localNumero;
	}
	
	protected Endereco getEndereco() {
		return this;
	}
}
