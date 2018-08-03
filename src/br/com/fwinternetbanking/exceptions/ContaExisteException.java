package br.com.fwinternetbanking.exceptions;

public class ContaExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 484887551850632526L;

	/**
	 * 
	 */

	public ContaExisteException() {
		super("Conta ja existente");
	}
}
