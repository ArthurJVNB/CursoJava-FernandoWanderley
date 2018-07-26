package br.com.testehibernate.model.exceptions;

public class SaldoNegativoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -362624516584298671L;

	public SaldoNegativoException() {
		super("Saldo negativo");
	}
}
