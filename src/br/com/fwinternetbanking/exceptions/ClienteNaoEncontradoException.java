package br.com.fwinternetbanking.exceptions;

public class ClienteNaoEncontradoException extends Exception{
	public ClienteNaoEncontradoException() {
		super("Cliente nao encontrado");
	}
}
