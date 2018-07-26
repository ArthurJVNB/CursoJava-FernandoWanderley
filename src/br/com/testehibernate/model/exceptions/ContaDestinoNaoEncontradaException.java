package br.com.testehibernate.model.exceptions;

public class ContaDestinoNaoEncontradaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3219967029311144598L;
	
	public ContaDestinoNaoEncontradaException() {
		super("Conta destino nao encontrada");
	}
}
