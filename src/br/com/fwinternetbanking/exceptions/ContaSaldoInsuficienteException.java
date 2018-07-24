package br.com.fwinternetbanking.exceptions;

public class ContaSaldoInsuficienteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaSaldoInsuficienteException() {
		super("Saldo insuficiente");
	}
}
