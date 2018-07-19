package br.com.fwinternetbanking.model;


public class Poupanca extends Conta {
	private static double TAXA_JUROS = 0.01; // 1%
	
    // CONSTRUCTOR 1
    public Poupanca(String numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }

    public void renderJuros(double taxa) {
        double saldoAtual = getSaldo();
        creditar(saldoAtual * TAXA_JUROS);
    }
}
