/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

/**
 *
 * @author Euller
 */
public class Endereco {

	private String cep;
	private String numero;
	private String Complemento;

	public Endereco(String cep, String numero, String Complemento) {
		this.cep = cep;
		this.numero = numero;
		this.Complemento = Complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String Complemento) {
		this.Complemento = Complemento;
	}

}
