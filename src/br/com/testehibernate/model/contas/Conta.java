package br.com.testehibernate.model.contas;

import br.com.testehibernate.model.exceptions.SaldoNegativoException;

public class Conta extends ContaAbstrata {

	public Conta() {}
	
	@Override
	public void debitar(double valor) throws SaldoNegativoException {
		setSaldo(getSaldo() - valor);
	}

}
