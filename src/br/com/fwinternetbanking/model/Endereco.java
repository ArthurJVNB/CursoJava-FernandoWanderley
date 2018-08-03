/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Euller
 */

@Entity
@Table (name = "TB_ENDERECO")
public class Endereco {

	@Override
	public String toString() {
		return "Endereco [clienteCpf=" + clienteCpf + ", cep=" + cep + ", numero=" + numero + ", Complemento="
				+ Complemento + "]";
	}

	@Id
	@Column (name = "TB_CLIENTE_CPF")
	private String clienteCpf;
	
	@Column (name = "CEP")
	private String cep;
	
	@Column (name = "NUMERO")
	private String numero;
	
	@Column (name = "COMPLEMENTO")
	private String Complemento;

	public Endereco() {}
	public Endereco(String cpf, String cep, String numero, String Complemento) {
		this.clienteCpf = cpf;
		this.cep = cep;
		this.numero = numero;
		this.Complemento = Complemento;
	}
	
	

	public String getClienteCpf() {
		return clienteCpf;
	}
	
	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
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
