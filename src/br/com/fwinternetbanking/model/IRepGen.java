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

    void inserir(G g);

    void atualizar(G g);

    void remover(String chave);

    boolean existe(String chave);

    G procurar(String chave);
}
