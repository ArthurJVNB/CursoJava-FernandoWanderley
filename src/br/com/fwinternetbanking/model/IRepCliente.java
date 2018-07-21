/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

/**
 *
 * @author Euller
 */
public interface IRepCliente extends IRepGen<Cliente> {

	public void inserir(Cliente cliente);

	public void atualizar(Cliente cliente);

	public Cliente procurar(String cpf);

	public void remover(Cliente cliente);
}
