package br.com.testehibernate.model.cliente;

public class Endereco {
	
	private String cep;
	private String localNumero;
	
	public Endereco(){}
	public Endereco(String cep, String localNumero) {
		this.cep = cep;
		this.localNumero = localNumero;
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
