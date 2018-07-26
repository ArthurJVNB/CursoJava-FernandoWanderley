package br.com.testehibernate.model.contas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.testehibernate.model.E;
import br.com.testehibernate.model.exceptions.ContaDestinoNaoEncontradaException;
import br.com.testehibernate.model.exceptions.SaldoNegativoException;

@Entity
@Table (name = "TB_CONTA")
public abstract class ContaAbstrata extends E<ContaAbstrata>{
	
	@Column (name = "NUMERO")
	private String numero;
	
	@Column (name = "SALDO")
	private double saldo;
	
	@Column (name = "TB_CLIENTE_CPF")
	private String cpfCliente;
	
	public ContaAbstrata() {}
	
	public ContaAbstrata(String numero, double saldo, String cpfCliente) {
		super(numero);
		this.numero = numero;
		this.saldo = saldo;
		this.cpfCliente = cpfCliente;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(double valor) throws SaldoNegativoException {
		if (valor <= saldo) {
			saldo = valor;
		} else {
			SaldoNegativoException e = new SaldoNegativoException();
			throw e;
		}
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(String cpf) {
		cpfCliente = cpf;
	}
	
	public void creditar(double valor) {
		saldo += valor;
	}
	
	public abstract void debitar(double valor) throws SaldoNegativoException;
	
	public void transferir(ContaAbstrata destino, double valor) {
		
		if (destino != null) {
			try {
				debitar(valor);
				destino.creditar(valor);
			} catch (SaldoNegativoException e) {
				e.printStackTrace(); // TODO throws e
			}
		} else {
			ContaDestinoNaoEncontradaException e = new ContaDestinoNaoEncontradaException();
			e.printStackTrace(); // TODO throws e
		}
	}
}
