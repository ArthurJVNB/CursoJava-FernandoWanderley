package br.com.fwinternetbanking.model;

import br.com.fwinternetbanking.exceptions.ArrayCheioException;
import br.com.fwinternetbanking.exceptions.ContaExisteException;
import br.com.fwinternetbanking.exceptions.ContaNaoEncontradaException;
import br.com.fwinternetbanking.exceptions.ContaSaldoInsuficienteException;
import br.com.fwinternetbanking.exceptions.ValorInvalidoException;

public class CadConta extends CadGen<ContaAbstrata> {

	private IRepConta contas;

	// CONSTRUCTOR
	public CadConta(IRepConta contas) {
		this.contas = contas;
	}

	// Inserir
	@Override
	public void inserir(ContaAbstrata conta) throws Exception {
		try {
			contas.inserir(conta);
		} catch (ContaExisteException | ArrayCheioException e) {
			throw e;
		}
	}

	// Remover
	@Override
	public void remover(ContaAbstrata conta) throws Exception {
		try {
			contas.remover(conta);
		} catch (ContaNaoEncontradaException e) {
			throw e;
		}
	}

	// Consultar
	@Override
	public ContaAbstrata consultar(String numeroConta) throws Exception {
		try {
			return contas.procurar(numeroConta);
		} catch (ContaNaoEncontradaException e) {
			throw e;
		}
	}

	// Atualizar
	@Override
	public void atualizar(ContaAbstrata conta) throws Exception {
		try {
			contas.atualizar(conta);
		} catch (ContaNaoEncontradaException e) {
			throw e;
		}
	}

	// Creditar
	public void creditar(String numeroConta, double valor) throws Exception {
		if (valor > 0) {
			if (contas.procurar(numeroConta) != null) {
				ContaAbstrata conta = consultar(numeroConta);
				conta.creditar(valor);
				contas.atualizar(conta);
			} else {
				throw new ContaNaoEncontradaException();
			}
		} else {
			throw new ValorInvalidoException();
		}
	}

	// Debitar
	public void debitar(String numeroConta, double valor) throws Exception {
		try {
			if (contas.procurar(numeroConta) != null) {
				ContaAbstrata conta = consultar(numeroConta);
				conta.debitar(valor);
			} else {
				throw new ContaNaoEncontradaException();
			}
		} catch (ContaSaldoInsuficienteException e) {
			throw e;
		}
	}

	// Transferir
	public void transferir(String numOrigem, String numDestino, double valor) throws Exception {
		try {
			ContaAbstrata contaOrigem = consultar(numOrigem);
			ContaAbstrata contaDestino = consultar(numDestino);
			contaOrigem.transferir(contaDestino, valor);
		} catch (ContaNaoEncontradaException | ContaSaldoInsuficienteException e) {
			throw e;
		}
	}
}
