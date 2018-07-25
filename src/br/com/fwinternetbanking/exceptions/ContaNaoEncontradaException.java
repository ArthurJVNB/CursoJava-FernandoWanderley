package br.com.fwinternetbanking.exceptions;

public class ContaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaNaoEncontradaException() {
		super("Conta nao encontrada");
	}
}
