package br.com.fwinternetbanking.model;

import br.com.fwinternetbanking.model.clientes.Cliente;
import br.com.fwinternetbanking.model.contas.ContaAbstrata;
import br.com.fwinternetbanking.model.contas.ContaBonificada;
import br.com.fwinternetbanking.model.contas.ContaImposto;
import br.com.fwinternetbanking.model.contas.Poupanca;
import br.com.fwinternetbanking.model.contas.TipoConta;

public class FactoryContas {
	public ContaAbstrata getTipoConta(int conta) {

		switch (conta) {
		case 0:
			return CriarContaImposto();
		case 1:
			return CriarContaBonificada();
		case 2:
			return CriarContaPoupanca();

		}

		return null;

	}
	
	private ContaAbstrata CriarContaBonificada() {
		return new ContaBonificada();
	}
	private ContaAbstrata CriarContaImposto() {
		return new ContaImposto();
	}
	private ContaAbstrata CriarContaPoupanca() {
		return new Poupanca();
	}
}
