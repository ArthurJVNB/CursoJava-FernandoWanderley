package br.com.fwinternetbanking.exceptions;

public class ClienteExisteException extends Exception{
	public ClienteExisteException() {
		super("Cliente ja existe");
	}
}
