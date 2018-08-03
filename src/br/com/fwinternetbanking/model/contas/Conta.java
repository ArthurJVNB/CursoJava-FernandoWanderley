package br.com.fwinternetbanking.model.contas;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fwinternetbanking.model.clientes.Cliente;

@Entity
@Table (name = "tb_conta")
public class Conta extends ContaAbstrata {
	
    // CONSTRUTORES
	public Conta() {}
    public Conta(String numero, double saldo, Cliente cliente, TipoConta tipo) {
        super(numero, saldo, cliente, tipo);
    }

    @Override
    public void debitar(double valor) {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente");	// TODO forma tempor�ria de avisar erro
        }
    }
}