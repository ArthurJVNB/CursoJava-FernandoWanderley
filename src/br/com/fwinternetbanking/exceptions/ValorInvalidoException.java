package br.com.fwinternetbanking.exceptions;

public class ValorInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6320746264561710789L;

	public ValorInvalidoException() {
		super("Informe um valor positivo");
	}

}
