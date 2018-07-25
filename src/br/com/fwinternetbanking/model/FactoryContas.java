package br.com.fwinternetbanking.model;

public class FactoryContas {
	public ContaAbstrata getTipoConta(int conta, Double saldo, String numero, Cliente cliente) {

		switch (conta) {
		case 0:
			return new ContaImposto(numero, saldo, cliente, TipoConta.ContaImposto);
		case 1:
			return new ContaBonificada(numero, saldo, cliente, TipoConta.ContaBonificada);
		case 2:
			return new Poupanca(numero, saldo, cliente, TipoConta.ContaPoupanca);

		}

		return null;

	}
}
