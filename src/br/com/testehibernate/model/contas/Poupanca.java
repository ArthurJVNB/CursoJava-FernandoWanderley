package br.com.testehibernate.model.contas;

public class Poupanca extends Conta {

	private static double TAXA_POUPANCA = 0.01;	// 1%
	
	public Poupanca() {}
	
	public void creditarPoupanca() {
		super.creditar(getSaldo() * TAXA_POUPANCA);
	}
}
