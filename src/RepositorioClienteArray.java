/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fwinternetbanking;

import fwinternetbanking.Cliente;

/**
 *
 * @author Euller
 */
public class RepositorioClienteArray {

    private Cliente[] clientes;
    private int indice;
    private final static int tamCache = 100;

    public RepositorioClienteArray() {
        indice = 0;
        clientes = new Cliente[tamCache];
    }

    public void inserir(Cliente c) {
        clientes[indice] = c;
        indice++;
    }

    private int procurarIndice(String cpf) {
        int i = 0;
        int ind = -1;

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                ind = i;
                break;
            }
            i++;
        }
        return ind;
    }

    public boolean existe(String cpf) {

        boolean resp = false;
        int i = this.procurarIndice(cpf);
        if (i != -1) {
            resp = true;
        }
        return resp;
    }

    public void atualizar(Cliente c) {
        
        int i = procurarIndice(c.getCpf());
        if (i != -1) {
            clientes[i] = c;
        } else {
            System.out.println("Cliente nao encontrado");
        }
    }

    public Cliente procurar(String cpf) {

        Cliente c = null;
        if (existe(cpf)) {
            int i = this.procurarIndice(cpf);
            c = clientes[i];
        } else {
            System.out.println("Cliente nao encontrado");
        }
        return c;
    }

    public void remover(String num) {
        if (existe(num)) {
            int i = this.procurarIndice(num);
            clientes[i] = clientes[indice - 1];
            clientes[indice - 1] = null;
            indice = indice - 1;
        } else {
            System.out.println("Cliente nao encontrado");
        }
    }
}
