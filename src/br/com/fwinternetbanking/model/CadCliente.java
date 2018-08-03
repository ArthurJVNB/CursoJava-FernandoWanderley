/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

import br.com.fwinternetbanking.exceptions.ArrayCheioException;
import br.com.fwinternetbanking.exceptions.ClienteExisteException;
import br.com.fwinternetbanking.exceptions.ClienteNaoEncontradoException;

/**
 *
 * @author Euller
 */
public class CadCliente extends CadGen<Cliente> {
	private IRepCliente clientes;

	public CadCliente(IRepCliente rep) {
		this.clientes = rep;
	}

	@Override
	public void inserir(Cliente cliente) throws Exception {
		try {
			clientes.inserir(cliente);

		} catch (ClienteExisteException | ArrayCheioException e) {
			throw e;
		}
	}

	@Override
        public void atualizar(Cliente cliente) throws Exception{
        	try {
        		clientes.atualizar(cliente);
        	}catch(ClienteNaoEncontradoException e) {
        		throw e;
        	}
        }

	@Override
	public Cliente consultar(String cpf) throws Exception {
		try {
			return clientes.procurar(cpf);
		}catch(ClienteNaoEncontradoException e) {
			throw e;
		}
	}

	@Override
	public void remover(Cliente cliente) throws Exception {
		try {
			clientes.remover(cliente);
		}catch(ClienteNaoEncontradoException e) {
			
		}
	}
}
