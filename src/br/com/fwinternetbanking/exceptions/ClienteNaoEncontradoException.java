package br.com.fwinternetbanking.exceptions;

public class ClienteNaoEncontradoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6401773052762322828L;

	/**
	 * 
	 */

	public ClienteNaoEncontradoException() {
		super("Cliente nao encontrado");
	}
}
