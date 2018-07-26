package br.com.testehibernate.model.contas;

public class ContaBonificada extends Conta {
	
	private static double TAXA_BONIFICACAO = 0.01; // 1%
	private double bonus;
	
	public ContaBonificada() {}
	
	public double getBonus() {
		return bonus;
	}
	
	public void setBonus(double valor) {
		bonus = valor;
	}
	
	@Override
	public void creditar(double valor) {
		bonus = valor * TAXA_BONIFICACAO;
		super.creditar(valor);
	}
	
	public void creditarBonus() {
		super.creditar(bonus);
	}
}
