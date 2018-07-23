package br.com.fwinternetbanking.exceptions;

public class ContaExisteException extends Exception{
	public ContaExisteException() {
		super("Conta ja existente");
	}
}
