package br.com.testehibernate.model.conta;

public class ContaBonificada extends Conta {
	
	private static double TAXA_BONIFICACAO = 0.01; // 1%
	private double bonus;
	
	public ContaBonificada() {}
	
	@Override
	public void creditar(double valor) {
		bonus = valor * TAXA_BONIFICACAO;
		super.creditar(valor);
	}
	
	public void creditarBonus() {
		super.creditar(bonus);
	}
}
