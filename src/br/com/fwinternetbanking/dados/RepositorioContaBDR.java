package br.com.fwinternetbanking.dados;

import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepGen;

public class RepositorioContaBDR implements IRepGen<ContaAbstrata> {

	@Override
	public void inserir(ContaAbstrata g) {
		
	}

	@Override
	public void atualizar(ContaAbstrata g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existe(String chave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContaAbstrata procurar(String chave) {
		// TODO Auto-generated method stub
		return null;
	}

}
