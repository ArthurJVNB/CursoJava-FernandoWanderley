package br.com.testehibernate.model.conta;

import br.com.testehibernate.model.E;
import br.com.testehibernate.model.exception.ContaDestinoNaoEncontradaException;
import br.com.testehibernate.model.exception.SaldoNegativoException;

public abstract class ContaAbstrata extends E<ContaAbstrata>{
	
	private String numero;
	private double saldo;
	private String cpfCliente;
	
	public ContaAbstrata() {}
	
	public ContaAbstrata(String numero, double saldo, String cpfCliente) {
		super(numero);
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
