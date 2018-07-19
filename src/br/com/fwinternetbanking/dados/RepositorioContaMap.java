package br.com.fwinternetbanking.dados;

import java.util.HashMap;

import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepConta;

public class RepositorioContaMap implements IRepConta{
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
		if (!contas.containsKey(key))
		{
			contas.put(key, conta);
		}
	}

	@Override
	public void atualizar(ContaAbstrata conta) {
		contas.replace(conta.getNumero(), conta);
	}

	@Override
	public void remover(String numeroConta) {
		contas.remove(numeroConta);
	}

	@Override
	public boolean existe(String numeroConta) {
		return contas.containsKey(numeroConta);
	}

	@Override
	public ContaAbstrata procurar(String numeroConta) {
		return contas.get(numeroConta);
	}
	// Metodos implementados de IRepConta - FIM
}
