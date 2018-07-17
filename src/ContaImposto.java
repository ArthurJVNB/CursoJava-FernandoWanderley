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
public class ContaImposto extends ContaAbstrata {
    
    public ContaImposto(double saldo, String numero){
        super(saldo, numero);
    }
    
    @Override
    public void debitar (double valor){
        this.saldo -= valor * 1.01;
    }
}
