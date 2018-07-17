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
public class ContaBonificada extends Conta {
    
    private double bonus;
    
    public ContaBonificada(float saldo, String numero) {
        super(saldo, numero);
    }

    public void renderBonus(double bonus){
        super.creditar(this.bonus);
        this.bonus = 0;
    }
    
    @Override
    public void creditar(double valor){
        this.bonus += (valor * 0.01);
        super.creditar(valor);
    }
    
}
