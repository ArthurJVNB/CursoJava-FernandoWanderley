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
public abstract class ContaAbstrata {

    double saldo;
    protected String numero;

    public ContaAbstrata(double saldo, String numero) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public void creditar(double valor) {
        saldo += valor;
    }

 
    public abstract void debitar(double valor);

    public void transferir(Conta c, double valor) {
        this.debitar(valor);
        c.creditar(valor);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

}
