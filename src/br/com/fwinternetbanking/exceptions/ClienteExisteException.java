package br.com.fwinternetbanking.exceptions;

public class ClienteExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -472724002318481412L;

	/**
	 * 
	 */

	public ClienteExisteException() {
		super("Cliente ja existe");
	}
}
