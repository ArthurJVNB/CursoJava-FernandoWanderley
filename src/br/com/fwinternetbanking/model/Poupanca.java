package br.com.fwinternetbanking.model;


public class Poupanca extends Conta {

    // CONSTRUCTOR 1
    public Poupanca(String numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }

    public void renderJuros(double taxa) {
        double saldoAtual = getSaldo();
        creditar(saldoAtual * (taxa / 100));
    }
}
