package br.com.fwinternetbanking.exceptions;

public class ContaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -592993699150715824L;

	/**
	 * 
	 */

	public ContaNaoEncontradaException() {
		super("Conta nao encontrada");
	}
}
