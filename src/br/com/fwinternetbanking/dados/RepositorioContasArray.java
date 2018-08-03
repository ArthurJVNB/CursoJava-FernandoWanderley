package br.com.fwinternetbanking.dados;

import br.com.fwinternetbanking.exceptions.ArrayCheioException;
import br.com.fwinternetbanking.exceptions.ContaExisteException;
import br.com.fwinternetbanking.exceptions.ContaNaoEncontradaException;
import br.com.fwinternetbanking.model.ContaAbstrata;
import br.com.fwinternetbanking.model.IRepConta;

public class RepositorioContasArray implements IRepConta {

	private ContaAbstrata[] contas;
	private int indice;
	private final static int tamCache = 100;

	public RepositorioContasArray() {
		indice = 0;
		contas = new ContaAbstrata[tamCache];
	}

	@Override
	public void inserir(ContaAbstrata c) throws Exception {
		try {
			if (!existe(c.getNumero())) {
				contas[indice] = c;
				indice++;
			} else {
				throw new ContaExisteException();
			}
		} catch (ArrayIndexOutOfBoundsException e) {

			throw new ArrayCheioException();
		}

	}

	@Override
	public void atualizar(ContaAbstrata c) throws Exception {

		int i = procurarIndice(c.getNumero());
		if (i != -1) {
			contas[i] = c;
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	@Override
	public void remover(ContaAbstrata c) throws Exception {
		if (existe(c.getNumero())) {
			int i = this.procurarIndice(c.getNumero());
			contas[i] = contas[indice - 1];
			contas[indice - 1] = null;
			indice = indice - 1;
		} else {
			throw new ContaNaoEncontradaException();
		}
	}

	private int procurarIndice(String numeroConta) {
		int i = 0;
		int ind = -1;

		for (ContaAbstrata c : contas) {
			if (c.getNumero().equals(numeroConta)) {
				ind = i;
				break;
			}
			i++;
		}
		return ind;
	}

	public boolean existe(String numeroConta) {
		boolean resp = false;
		int i = this.procurarIndice(numeroConta);
		if (i != -1) {
			resp = true;
		}
		return resp;
	}

	@Override
	public ContaAbstrata procurar(String numeroConta) throws Exception {
		ContaAbstrata c = null;

		if (existe(numeroConta)) {
			int i = this.procurarIndice(numeroConta);
			c = contas[i];
		} else {
			throw new ContaNaoEncontradaException();
		}

		return c;
	}

}