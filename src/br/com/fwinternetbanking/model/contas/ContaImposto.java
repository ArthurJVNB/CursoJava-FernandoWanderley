package br.com.fwinternetbanking.model.contas;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fwinternetbanking.model.clientes.Cliente;

@Entity
@Table (name = "tb_conta")
public class ContaImposto extends ContaAbstrata {

    private static double TAXA_IMPOSTO = 0.01;	// 1%

    public ContaImposto() {}
    
    public ContaImposto(String numero, double saldo, Cliente cliente, TipoConta tipo) {
        super(numero, saldo, cliente, tipo);
    }

    @Override
    public void debitar(double valor) {
        double imposto = valor * TAXA_IMPOSTO;

        // eh como se estivesse escrito:
        // saldo = saldo - (valor - imposto);
        setSaldo(getSaldo() - (valor + imposto));
    }
}