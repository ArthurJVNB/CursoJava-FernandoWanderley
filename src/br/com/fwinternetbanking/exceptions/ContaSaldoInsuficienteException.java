package br.com.fwinternetbanking.exceptions;

public class ContaSaldoInsuficienteException extends Exception {
	public ContaSaldoInsuficienteException() {
		super("Saldo insuficiente");
	}
}
