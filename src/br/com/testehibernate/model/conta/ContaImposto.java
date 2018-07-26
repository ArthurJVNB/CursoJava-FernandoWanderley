package br.com.testehibernate.model.conta;

import br.com.testehibernate.model.exception.SaldoNegativoException;

public class ContaImposto extends ContaAbstrata {

	private static double TAXA_IMPOSTO = 0.01;	// 1%
	
	@Override
	public void debitar(double valor) throws SaldoNegativoException {
		setSaldo(valor + valor*TAXA_IMPOSTO);
	}

}
