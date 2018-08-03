package br.com.fwinternetbanking.exceptions;

public class ContaSaldoInsuficienteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5219651261982248334L;

	/**
	 * 
	 */

	public ContaSaldoInsuficienteException() {
		super("Saldo insuficiente");
	}
}
