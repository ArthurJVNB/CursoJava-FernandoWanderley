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
public class RepositorioContaAbstrataArray implements IRepConta{

    private static ContaAbstrata[] contas;
    private int indice;
    private final static int TAM_CACHE = 100;

    public RepositorioContaAbstrataArray() {
        indice = 0;
        contas = new ContaAbstrata[TAM_CACHE];
    }

    @Override
    public void inserir(ContaAbstrata c) {
        contas[indice] = c;
        indice++;
    }

    private int procurarIndice(String num) {
        int i = 0;
        int ind = -1;

        for (ContaAbstrata c : contas) {
            if (c.getNumero().equals(num)) {
                ind = i;
                break;
            }
            i++;
        }
        return ind;
    }

    @Override
    public boolean existe(String num) {

        boolean resp = false;
        int i = this.procurarIndice(num);
        if (i != -1) {
            resp = true;
        }
        return resp;
    }

    @Override
    public void atualizar(ContaAbstrata c) {

        int i = procurarIndice(c.getNumero());
        if (i != -1) {
            contas[i] = c;
        } else {
            System.out.println("Conta nao encontrada");
        }
    }

    @Override
    public ContaAbstrata procurar(String num) {

        ContaAbstrata c = null;
        if (existe(num)) {
            int i = this.procurarIndice(num);
            c = contas[i];
        } else {
            System.out.println("Conta nao encontrada");
        }
        return c;
    }
    
    @Override
    public void remover(String num){
        if(existe(num)){
            int i = this.procurarIndice(num);
            contas[i] = contas[indice - 1];
            contas[indice - 1] = null;
            indice = indice -1;
        }else{
            System.out.println("Conta nao encontrada");
        }
    }
}


