package br.com.fwinternetbanking.dados;

import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepConta;

public class RepositorioContasArray implements IRepConta {

	private ContaAbstrata[] contas;
	private int indice;

	public RepositorioContasArray() {
		contas = new ContaAbstrata[100];
		indice = 0;
	}

	@Override
	public void inserir(ContaAbstrata conta) {
		contas[indice] = conta;
		indice++;
	}

	@Override
	public void atualizar(ContaAbstrata conta) {
		if (existe(conta.getNumero())) {
			int resultadoIndice = procurarIndice(conta.getNumero());
			contas[resultadoIndice] = conta;
		}
	}

	@Override
	public void remover(ContaAbstrata c) {
		if (existe(c.getNumero())) {
			int resultadoIndice = procurarIndice(c.getNumero()); // o �ndice da conta que se quer apagar

			for (int posSeguinte = resultadoIndice + 1; posSeguinte < indice; posSeguinte++) // at� o �NDICE, pois
																								// ele est� sempre �
																								// frente
			{
				int posAtual = posSeguinte - 1; // <<<<----- s� para estudo
				contas[posAtual] = contas[posSeguinte];
			}

			indice--;
		}
	}

	private int procurarIndice(String numeroConta) {
		int resultado = -1;

		for (int i = 0; i < contas.length; i++) {
			if (contas[i] != null && contas[i].getNumero().equals(numeroConta)) {
				resultado = i;
			}
		}

		return resultado;
	}

	
	public boolean existe(String numeroConta) {
		boolean resultado = false;

		if (procurarIndice(numeroConta) >= 0) {
			resultado = true;
		}

		return resultado;
	}

	@Override
	public ContaAbstrata procurar(String numeroConta) {
		ContaAbstrata resultadoConta = null;

		if (existe(numeroConta)) {
			int resultadoIndice = procurarIndice(numeroConta);
			resultadoConta = contas[resultadoIndice];
		}

		return resultadoConta;
	}
}
