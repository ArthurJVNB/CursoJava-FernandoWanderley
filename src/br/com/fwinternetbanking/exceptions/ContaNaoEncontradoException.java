package br.com.fwinternetbanking.exceptions;

public class ContaNaoEncontradoException extends Exception {
	public ContaNaoEncontradoException() {
		super("Conta nao encontrada");
	}
}
