package br.com.testehibernate.model.contas;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.testehibernate.model.exceptions.SaldoNegativoException;

@Entity
@Table (name = "TB_CONTA")
public class Conta extends ContaAbstrata {

	public Conta() {}
	
	@Override
	public void debitar(double valor) throws SaldoNegativoException {
		setSaldo(getSaldo() - valor);
	}

}
