/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwinternetbanking.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fwinternetbanking.model.Cliente;

/**
 *
 * @author Euller
 */

@Entity
@Table (name = "tb_conta")
public class ContaBonificada extends Conta {
    
    private double bonus;
    
    // CONSTRUTORES
    public ContaBonificada() {}
    public ContaBonificada(String numero, double saldo, Cliente cliente, TipoConta tipo) {
        super(numero, saldo, cliente, tipo);
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
