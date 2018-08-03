package br.com.fwinternetbanking.dados;

import java.util.HashMap;

import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepConta;

public class RepositorioContaMap implements IRepConta {
	private HashMap<String, ContaAbstrata> contas;
	private static int CAPACIDADE_INICIAL = 30;
	
	// CONSTRUTOR
	public RepositorioContaMap() {
		contas = new HashMap<>(CAPACIDADE_INICIAL); // fator de carga: 0.75 (padrao)
	}
	
	// Metodos implementados de IRepConta - INICIO
	@Override
	public void inserir(ContaAbstrata conta) {
		String key = conta.getNumero();
		if (!contas.containsKey(key))	// pra impedir que substitua a conta que estiver numa mesma key
		{
			contas.put(key, conta);
		}
	}

	@Override
	public void atualizar(ContaAbstrata conta) {
		contas.replace(conta.getNumero(), conta);
		
		// A diferenca para "put" eh que esse so substitui o valor naquela chave se ja tiver
		// ALGUM valor na chave que foi passada (nao se preocupa qual o valor - so quer
		// saber se tem algum valor naquela chave).
		
		// O "put" coloca naquela chave o valor que foi passado, independente se tinha algo
		// antes ou nao.
	}

	@Override
	public void remover(ContaAbstrata conta) {
		contas.remove(conta);
	}

	public boolean existe(String numeroConta) {
		return contas.containsKey(numeroConta);
	}

	@Override
	public ContaAbstrata procurar(String numeroConta) {
		return contas.get(numeroConta);
	}
	// Metodos implementados de IRepConta - FIM
}
