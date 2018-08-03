/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

import br.com.fwinternetbanking.dados.RepositorioClienteArray;
import br.com.fwinternetbanking.dados.RepositorioContasArray;
import br.com.fwinternetbanking.exceptions.ArrayCheioException;
import br.com.fwinternetbanking.exceptions.ClienteExisteException;
import br.com.fwinternetbanking.exceptions.ClienteNaoEncontradoException;
import br.com.fwinternetbanking.exceptions.ContaExisteException;
import br.com.fwinternetbanking.exceptions.ContaNaoEncontradaException;
import br.com.fwinternetbanking.exceptions.ContaSaldoInsuficienteException;
import br.com.fwinternetbanking.exceptions.ValorInvalidoException;

/**
 *
 * @author Euller
 */
public class Fachada {
	private static Fachada instancia;
	private CadCliente clientes;
	private CadConta contas;

	public static Fachada obterInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	private Fachada() {
		initCadastros();
	}

	private void initCadastros() {
		RepositorioClienteArray repClientes = new RepositorioClienteArray();
		RepositorioContasArray repContas = new RepositorioContasArray();

		contas = new CadConta(repContas);
		clientes = new CadCliente(repClientes);
	}

//    metodos de conta
	public void cadastrarConta(ContaAbstrata c) throws Exception {
		try {
			contas.inserir(c);
		} catch (ArrayCheioException | ContaExisteException e) {
			e.getMessage();
		}
	}

	public void atualizarConta(ContaAbstrata c) throws Exception {
		try {
			contas.atualizar(c);
		} catch (ContaNaoEncontradaException e) {
			e.getMessage();
		}
	}

	public ContaAbstrata procurarConta(String num) throws Exception {
		try {
			return contas.consultar(num);
		} catch (ContaNaoEncontradaException e) {
			e.getMessage();
		}
		return null;
	}

	public void descadastrarConta(ContaAbstrata c) throws Exception {
		try {
			contas.remover(c);
		} catch (ContaNaoEncontradaException e) {
			e.getMessage();
		}
	}

	public void creditar(String num, double valor) throws Exception {
		try {
			contas.creditar(num, valor);
		} catch (ContaNaoEncontradaException | ValorInvalidoException e) {
			e.getMessage();
		}
	}

	public void debitar(String num, double valor) throws Exception {
		try {
			contas.debitar(num, valor);
		} catch (ContaNaoEncontradaException | ContaSaldoInsuficienteException e) {
			e.getMessage();
		}
	}

	public void transferir(String numOrigem, String numDestino, double valor) throws Exception {
		try {
			ContaAbstrata origem = contas.consultar(numOrigem);
			ContaAbstrata destino = contas.consultar(numDestino);

			if (origem != null && destino != null) {
				origem.transferir(destino, valor);
			}
		} catch (ContaNaoEncontradaException | ContaSaldoInsuficienteException e) {
			e.getMessage();
		}
	}

//    metodos de cliente

	public void cadastrarCliente(Cliente c) throws Exception {
		try {
			clientes.inserir(c);
		} catch (ArrayCheioException | ClienteExisteException e) {
			e.getMessage();
		}
	}

	public void atualizarCliente(Cliente c) throws Exception {
		try {
			clientes.atualizar(c);
		} catch (ClienteNaoEncontradoException e) {
			e.getMessage();
		}
	}

	public Cliente procurarCliente(String cpf) throws Exception {
		try {
			return clientes.consultar(cpf);
		} catch (ClienteNaoEncontradoException e) {
			e.getMessage();
		}
		return null;
	}

	public void descadastrarCliente(Cliente c) throws Exception {
		try {
			clientes.remover(c);
		} catch (ClienteNaoEncontradoException e) {
			e.getMessage();
		}
	}
}
