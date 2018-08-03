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
public interface IRepGen<G> {

	public void inserir(G g) throws Exception;

	public void atualizar(G g) throws Exception;

	public void remover(G g) throws Exception;

	public G procurar(String chave) throws Exception;
}
