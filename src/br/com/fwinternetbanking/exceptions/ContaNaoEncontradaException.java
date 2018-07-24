package br.com.fwinternetbanking.exceptions;

public class ContaNaoEncontradaException extends Exception {
	public ContaNaoEncontradaException() {
		super("Conta nao encontrada");
	}
}
