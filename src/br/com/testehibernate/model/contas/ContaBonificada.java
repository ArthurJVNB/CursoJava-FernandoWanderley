package br.com.testehibernate.model.contas;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "TB_CONTA")
public class ContaBonificada extends Conta {
	
	private static double TAXA_BONIFICACAO = 0.01; // 1%
	
	// TODO ver se precisa salvar o bonus atual
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
