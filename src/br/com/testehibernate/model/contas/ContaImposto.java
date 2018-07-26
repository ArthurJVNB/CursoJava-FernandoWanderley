package br.com.testehibernate.model.contas;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.testehibernate.model.exceptions.SaldoNegativoException;

@Entity
@Table (name = "TB_CONTA")
public class ContaImposto extends ContaAbstrata {

	private static double TAXA_IMPOSTO = 0.01;	// 1%
	
	public ContaImposto() {}
	
	@Override
	public void debitar(double valor) throws SaldoNegativoException {
		setSaldo(valor + valor*TAXA_IMPOSTO);
	}

}
