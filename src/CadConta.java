/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwinternetbanking;

/**
 *
 * @author Euller
 */
public class CadConta {

    private IRepConta contas;

    public CadConta(IRepConta rep) {
        this.contas = rep;
    }

    public void inserir(ContaAbstrata conta) {
        if (!contas.existe(conta.getNumero())) {
            contas.inserir(conta);
        } else {
            System.out.println("Conta ja cadastrada");
        }
    }

    public void atualizar(ContaAbstrata conta) {
        contas.atualizar(conta);
    }

    public ContaAbstrata consultar(String numero) {
        return contas.procurar(numero);
    }

    public void remover(String numero) {
        contas.remover(numero);
    }

}
