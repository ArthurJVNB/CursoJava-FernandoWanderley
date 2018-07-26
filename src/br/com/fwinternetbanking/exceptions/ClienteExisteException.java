package br.com.fwinternetbanking.exceptions;

public class ClienteExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteExisteException() {
		super("Cliente ja existe");
	}
}
