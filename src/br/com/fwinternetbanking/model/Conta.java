package br.com.fwinternetbanking.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fwinternetbanking.exceptions.ContaSaldoInsuficienteException;
import br.com.fwinternetbanking.model.Cliente;

@Entity
@Table (name = "tb_conta")
public class Conta extends ContaAbstrata {
	
    // CONSTRUTORES
	public Conta() {}
    public Conta(String numero, double saldo, Cliente cliente, TipoConta tipo) {
        super(numero, saldo, cliente, tipo);
    }

    @Override
    public void debitar(double valor) throws Exception {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
        } else {
            throw new ContaSaldoInsuficienteException();
        }
    }
}
