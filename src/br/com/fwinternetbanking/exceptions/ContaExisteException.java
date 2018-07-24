package br.com.fwinternetbanking.exceptions;

public class ContaExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaExisteException() {
		super("Conta ja existente");
	}
}
