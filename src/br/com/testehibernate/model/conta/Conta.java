package br.com.testehibernate.model.conta;

import br.com.testehibernate.model.exception.SaldoNegativoException;

public class Conta extends ContaAbstrata {

	@Override
	public void debitar(double valor) throws SaldoNegativoException {
		setSaldo(getSaldo() - valor);
	}

}
